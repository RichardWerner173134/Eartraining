import components.SoundManager;
import frame.Home;
import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        //new Home();
        Player player = new Player();
        player.play("V0 C4QQ V2 B5QQ");
    }
}
