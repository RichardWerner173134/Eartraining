package components;


import components.notepicker.ChromaticNotePicker;
import components.notepicker.DiatonicNotePicker;
import components.notepicker.INotePicker;
import components.notepicker.OneTwoThreeFourFiveNotePicker;
import lombok.Getter;
import model.oldStuff.Note;
import org.jfugue.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static model.oldStuff.Note.isHigher;

@Getter
public class SoundManager {

    private List<Note> notes;
    private Config config;
    private Player player;


    public SoundManager() {
        notes = new ArrayList<>();
        player = new Player();
        config = Config.getInstance();

        this.notes = pickSound();
        playCurrentSound();
    }

    public void playCurrentSound() {
        player.close();
        StringBuilder sb = new StringBuilder();
        StringBuilder logSb = new StringBuilder();

        int i = 0;

        List<Note> collect = notes
                .stream()
                .sorted((Note n1, Note n2) -> {
                    if (isHigher(n1, n2)) return 1;
                    else return -1;
                })
                .collect(Collectors.toList());

        for(Note note : collect){
            try {
                logSb.append(note.getSoundString()).append(", ");
                sb.append("V")
                        .append(i)
                        .append(" ")
                        .append(note.getSoundString())
                        .append("QQQQ")
                        .append(" ");
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }

        System.out.println("playing: " + logSb.toString());
        Thread thread = new Thread(() -> player.play(sb.toString()));
        thread.start();
    }

    private List<Note> pickSound() {
        List<Note> pickedNotes = new ArrayList<>();
        Config.ScaleDegreeMix scaleDegreeMix = config.getScaleDegreeMix();

        while(notes.size() + pickedNotes.size() < config.getNumberOfNotes().getValue()){
            INotePicker notePicker = null;
            Note newRandomNote = null;
            switch(scaleDegreeMix){
                case ONE_TWO_THREE_FOUR_FIVE:
                    notePicker = new OneTwoThreeFourFiveNotePicker();
                    break;
                case ALL_DIATONIC:
                    notePicker = new DiatonicNotePicker();
                    break;
                case CHROMATIC:
                    notePicker = new ChromaticNotePicker();
                    break;
            }

            newRandomNote = notePicker.pickNote();

            if(!pickedNotes.contains(newRandomNote)) {
                int maxAccidentals = 1;
                int accidentalsFound = 0;

                int currentLowerRegisterNotes = 0;
                int maxNotesLowerRegister = config.getMaxNotesLowerRegister();

                int lowerRegisterOctave = config.getOctaveNumberIntervall()[0];

                for(Note note : pickedNotes){
                    // count accidentals in pickedNotes
                    if(note.getSound().getAccidental() != 'n'){
                        accidentalsFound++;
                    }
                    // count notes in the lowerRegister
                    if(note.getOctave() == lowerRegisterOctave){
                        currentLowerRegisterNotes++;
                    }
                }

                // make sure there are just maxAccidentals in pickedNotes
                if(accidentalsFound >= maxAccidentals && newRandomNote.getSound().getAccidental() != 'n'){
                    // too many accidentals... note skipped
                    continue;
                } else if(currentLowerRegisterNotes >= maxNotesLowerRegister && newRandomNote.getOctave() == lowerRegisterOctave) {
                    // too many lower register notes... note skipped
                    continue;
                } else {
                    pickedNotes.add(newRandomNote);
                }
            } else {
                // note already in pickedNotes... note skipped
                continue;
            }
        }
        return pickedNotes;
    }

    public void playNewSound() {
        notes = new ArrayList<>();
        notes = pickSound();
        playCurrentSound();
    }

    public static Note getNote(int scaleDegree, int accidental, int octave) throws Exception {
        char n;
        if(scaleDegree == 1 || scaleDegree == 5){
            n = 'n';
        } else if(scaleDegree == 4){
            n = accidental == 1 ? '#' : 'n';
        } else {
            n = accidental == 1 ? 'b' : 'n';
        }
        return Note.getSoundType(scaleDegree, n, octave);

    }

    public void playCadence(){
        player.close();

        StringBuilder s = new StringBuilder();
        s.append("V0 C4Q C4Q D4Q E4QQ ");
        s.append("V1 E4Q F4Q F4Q G4QQ ");
        s.append("V2 G4Q A4Q G4Q C5QQ ");
        s.append("V4 RQ RQ B4Q RQQ");

        Thread t = new Thread(() -> player.play(s.toString()));
        t.start();
    }

    public void playSoundSeparately() {
        player.close();
        StringBuilder sb = new StringBuilder();
        notes.stream().sorted((n1, n2) -> {
            if (isHigher(n1, n2)) return 1;
            else return -1;
        }).forEach(note  -> sb.append(note.getSoundString()).append("Q "));

        Thread thread = new Thread(() -> player.play(sb.toString()));
        thread.start();
    }
}
