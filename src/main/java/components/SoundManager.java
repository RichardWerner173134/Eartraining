package components;


import components.notepicker.ChromaticNotePicker;
import components.notepicker.DiatonicNotePicker;
import components.notepicker.INotePicker;
import components.notepicker.OneTwoThreeFourFiveNotePicker;
import lombok.Getter;
import org.jfugue.Player;
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
        StringBuilder sbSeparated = new StringBuilder();
        StringBuilder logSb = new StringBuilder();

        int i = 0;
        for(Note note : notes){
            sbSeparated.append(note.getSoundString()).append("QQ ");
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
        Player player = new Player();

        StringBuilder s = new StringBuilder();
        s.append("V0 C4Q C4Q D4Q E4QQ ");
        s.append("V1 E4Q F4Q F4Q G4QQ ");
        s.append("V2 G4Q A4Q G4Q C5QQ ");
        s.append("V4 RQ RQ B4Q RQQ");

        Thread t = new Thread(() -> player.play(s.toString()));
        t.start();
    }
}
