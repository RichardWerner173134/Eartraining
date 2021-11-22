package components.chordpicker;

import model.CircleOfFifths;
import model.CircularLinkedListNode;
import model.conceptOfChords.Chord;
import model.conceptOfIntervals.NoteHolder;
import model.conceptOfNote.Note;

import java.util.ArrayList;
import java.util.Iterator;

import static model.conceptOfChords.ChordType.*;
import static model.conceptOfChords.voicing.ChordVoicing.getVoicingsForChordType;

public class TriadicChordPicker extends AbstractChordPicker {

    private static TriadicChordPicker instance;

    public static TriadicChordPicker getInstance(){
        if(instance == null){
            try {
                instance = new TriadicChordPicker();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private TriadicChordPicker() throws Exception {
        chords = new ArrayList<>();

        CircleOfFifths instance = CircleOfFifths.getInstance();
        instance.setIteratingDirection(CircleOfFifths.Direction.UP);
        instance.resetIterator();

        Iterator<CircularLinkedListNode> circleIterator = instance.getNote().iterator();

        boolean firstRun = true;

        Note note = ((NoteHolder)circleIterator.next().getValue()).getNote(CircleOfFifths.Direction.UP);
        while(note != Note.C || firstRun) {
            firstRun = false;
            chords.add(new Chord(note, MAJOR, getVoicingsForChordType(MAJOR)));
            chords.add(new Chord(note, MINOR, getVoicingsForChordType(MINOR)));
            chords.add(new Chord(note, DIMINISHED, getVoicingsForChordType(DIMINISHED)));
            chords.add(new Chord(note, AUGMENTED, getVoicingsForChordType(AUGMENTED)));

            note = ((NoteHolder)circleIterator.next().getValue()).getNote(CircleOfFifths.Direction.UP);
        }
    }
}
