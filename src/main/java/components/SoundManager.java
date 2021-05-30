package components;


import lombok.Getter;
import org.jfugue.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class SoundManager {

    private List<Sound> sounds;
    private Config config;


    public SoundManager() {
        sounds = new ArrayList<>();

        config = Config.getInstance();

        this.sounds = pickSound();
        playCurrentSound();
    }

    public void playCurrentSound() {
        Player player = new Player();
        StringBuilder sb = new StringBuilder();
        StringBuilder logSb = new StringBuilder();

        int i = 0;
        for(Sound s : sounds){
            try {
                logSb.append(s.getSoundString()).append(", ");
                sb.append("V")
                        .append(i)
                        .append(" ")
                        .append(s.getSoundString())
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

    private List<Sound> pickSound() {
        List<Sound> pickedSounds = new ArrayList<>();

        Random rand = new Random();

        for(int i = 0; i < config.getIntNumberOfNotes(); i++){
            Sound newSound = generateSound(rand.nextInt(7) + 1, rand.nextInt(2));
            if(!pickedSounds.contains(newSound)) {
                pickedSounds.add(newSound);
            } else {
                i--;
            }
        }

        return pickedSounds;
    }

    public void playNewSound() {
        sounds = pickSound();
        playCurrentSound();
    }

    private Sound generateSound(int scaleDegree, int accidental) {
        if(scaleDegree == 1 || scaleDegree == 5){
            return Sound.getSoundType(scaleDegree, 'n');
        } else {
            if(accidental == 0) {
                return Sound.getSoundType(scaleDegree, 'n');
            } else {
                if(scaleDegree == 4){
                    return Sound.getSoundType(scaleDegree, '#');
                }else {
                    return Sound.getSoundType(scaleDegree, 'b');
                }
            }
        }
    }

    public void playCadence(){
        Player player = new Player();
        Thread t = new Thread(() -> player.play("CMajQ FMajQ GMajQ CMajQQ"));
        t.start();
    }
}
