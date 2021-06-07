package components;


import components.notepicker.ChromaticNotePicker;
import components.notepicker.DiatonicNotePicker;
import components.notepicker.INotePicker;
import components.notepicker.OneTwoThreeFourFiveNotePicker;
import lombok.Getter;
import org.jfugue.player.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SoundManager {

    private List<Note> notes;
    private Config config;


    public SoundManager() {
        notes = new ArrayList<>();

        config = Config.getInstance();

        this.notes = pickSound();
        playCurrentSound();
    }

    public void playCurrentSound() {
        Player player = new Player();
        StringBuilder sb = new StringBuilder();
        StringBuilder logSb = new StringBuilder();

        int i = 0;
        int octaveDebugCount = 0;
        for(Note note : notes){
            try {
                if(note.getOctave() == 3){
                    octaveDebugCount++;
                }
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
        System.out.println("WORKING: " + octaveDebugCount);

        System.out.println("playing: " + logSb.toString());
        Thread t2 = new Thread(() -> player.play(sb.toString()));
        t2.start();

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
                    System.out.println("too many accidentals... note skipped");
                    continue;
                } else if(currentLowerRegisterNotes >= maxNotesLowerRegister && newRandomNote.getOctave() == lowerRegisterOctave) {
                    System.out.println("too many lower register notes... note skipped");
                    continue;
                } else {
                    if(newRandomNote.getOctave() == 3){
                        System.out.println("asjd");
                    }
                    pickedNotes.add(newRandomNote);
                }
            } else {
                System.out.println("note already in pickedNotes... note skipped");
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
        Player player = new Player();
        Thread t = new Thread(() -> player.play("CMajQ FMajQ GMajQ CMajQQ"));
        t.start();
    }
}
