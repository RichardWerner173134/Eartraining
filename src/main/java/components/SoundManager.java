package components;


import org.jfugue.player.Player;

import java.util.LinkedList;

@Deprecated
public class SoundManager {


    private LinkedList<Sound> sounds;
    private Config config;

    public SoundManager(){
        sounds = new LinkedList<>();
        loadSounds();

        config = Config.getInstance();
    }

    private void loadSounds() {
        // load sounds
        Player player = new Player();

        Thread t = new Thread(() -> player.play("V0 CQQQQ V1 EQQQQ V2 GQQQQ"));
        t.start();
    }
}
