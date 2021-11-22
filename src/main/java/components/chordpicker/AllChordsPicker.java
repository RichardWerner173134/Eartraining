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

public class AllChordsPicker extends AbstractChordPicker {

    private static AllChordsPicker instance;

    public static AllChordsPicker getInstance(){
        if(instance == null){
            try {
                instance = new AllChordsPicker();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private AllChordsPicker() throws Exception {
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

            chords.add(new Chord(note, MAJOR_SEVENTH, getVoicingsForChordType(MAJOR_SEVENTH)));
            chords.add(new Chord(note, MINOR_SEVENTH, getVoicingsForChordType(MINOR_SEVENTH)));
            chords.add(new Chord(note, DOMINANT_SEVENTH, getVoicingsForChordType(DOMINANT_SEVENTH)));
            chords.add(new Chord(note, HALF_DIMINISHED_SEVENTH, getVoicingsForChordType(HALF_DIMINISHED_SEVENTH)));
            chords.add(new Chord(note, FULLY_DIMINISHED_SEVEN, getVoicingsForChordType(FULLY_DIMINISHED_SEVEN)));
            chords.add(new Chord(note, MINOR_MAJOR_SEVENTH, getVoicingsForChordType(MINOR_MAJOR_SEVENTH)));

            note = ((NoteHolder)circleIterator.next().getValue()).getNote(CircleOfFifths.Direction.UP);
        }
    }
}
