package components;


import lombok.Getter;
import org.jfugue.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        for(Note note : notes){
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

        //Thread t = new Thread(() -> player.play("V0 CQQQQ V1 EbQQQQ V2 GQQQQ"));
        //Thread t3 = new Thread(() -> player.play("V0 CQQQQ V1 EbQQQQ V2 GQQQQ"));
        //t.start();
        //t3.start();
    }

    private List<Note> pickSound() {
        List<Note> pickedNotes = new ArrayList<>();

        Random rand = new Random();

        for(int i = 0; i < config.getIntNumberOfNotes(); i++){
            Note newRandomNote = null;
            try {
                newRandomNote = getNote(rand.nextInt(7) + 1, rand.nextInt(2), rand.nextInt(3) + 3);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(!pickedNotes.contains(newRandomNote)) {
                // count accidentals in pickedNotes
                int maxAccidentals = 1;
                int accidentalsFound = 0;
                for(Note note : pickedNotes){
                    if(note.getSound().getAccidental() != 'n'){
                        accidentalsFound++;
                    }
                }

                // make sure there are just maxAccidentals in pickedNotes
                if(accidentalsFound == maxAccidentals && newRandomNote.getSound().getAccidental() != 'n'){
                    i--;
                } else {
                    pickedNotes.add(newRandomNote);
                }
            } else {
                i--;
            }
        }

        return pickedNotes;
    }

    public void playNewSound() {
        notes = pickSound();
        playCurrentSound();
    }

    private Note getNote(int scaleDegree, int accidental, int octave) throws Exception {
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
