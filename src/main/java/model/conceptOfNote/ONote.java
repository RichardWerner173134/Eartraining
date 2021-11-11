package model.conceptOfNote;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@AllArgsConstructor
public class ONote {
    private Note note;
    private Octave octave;

    /**
     * determines if two given onotes are enharmonic identical
     * takes octaves of onotes in consideration
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isEnharmonic(ONote n1, ONote n2){
        if(!Note.isEnharmonic(n1.getNote(), n2.getNote())){
            return false;
        }

        int val1 = noteToInt(n1);
        int val2 = noteToInt(n2);

        return val1 == val2;
    }

    /**
     * converts a Note associated with an octave to an unique integer
     * @param oNote
     * @return
     */
    public static int noteToInt(ONote oNote){
        int posWithoutOctave1 = oNote.getNote().getLetter().getPos() + oNote.getNote().getAccidental().getDisplacement();
        int octaveMul = oNote.getOctave().getNumber() - 1;
        octaveMul = posWithoutOctave1 / 12 > 1 ? octaveMul + 1 : octaveMul;
        return 12 * octaveMul + posWithoutOctave1;
    }

    public static List<ONote> getFullONoteList(){
        List<ONote> allONoteList = new ArrayList<>();
        List<Octave> orderedOctaves = Octave.getOrderedOctaves();
        List<Note> allNotes = Note.getAllNotes();

        for(Octave octave : orderedOctaves){
            for(Note note : allNotes){
                ONote newNote = new ONote(note, octave);
                allONoteList.add(newNote);
            }
        }

        return allONoteList;
    }

    public static boolean areEqual(ONote n1, ONote n2){
        return n1.getNote() == n2.getNote() &&
                n1.getOctave() == n2.getOctave();
    }
}
