import frame.Home;
import model.conceptOfChords.Chord;
import model.conceptOfChords.ChordType;
import model.conceptOfNote.Note;
import org.jfugue.Player;

import java.util.List;

import static model.conceptOfNote.Note.C;

public class Main {
    public static void main(String[] args) {
        new Home();
        /*Player player = new Player();
        Chord cMaj7 = new Chord(C, ChordType.MINOR_SEVENTH, null);
        List<Note> notes = cMaj7.getNotes();
        String playString = "";
        for(Note n : notes){
            playString += n.toString() + "4qq ";
        }
        player.play(playString);*/
    }
}
