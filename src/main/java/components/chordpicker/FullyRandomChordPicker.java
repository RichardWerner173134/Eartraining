package components.chordpicker;

import model.CircleOfFifths;
import model.CircularLinkedListNode;
import model.conceptOfChords.Chord;
import model.conceptOfChords.ChordType;
import model.conceptOfIntervals.NoteHolder;
import model.conceptOfNote.Note;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FullyRandomChordPicker implements IChordPicker{

    private List<Chord> chords;

    public FullyRandomChordPicker() {
        chords = new ArrayList<>();

        CircleOfFifths instance = CircleOfFifths.getInstance();
        instance.setIteratingDirection(CircleOfFifths.Direction.UP);
        instance.resetIterator();

        Iterator<CircularLinkedListNode> circleIterator = instance.getNote().iterator();

        boolean firstRun = true;

        Note note = ((NoteHolder)circleIterator.next().getValue()).getNote(CircleOfFifths.Direction.UP);
        while(note != Note.C || firstRun) {
            firstRun = false;
            chords.add(new Chord(note, ChordType.MAJOR, null));
            chords.add(new Chord(note, ChordType.MINOR, null));
            chords.add(new Chord(note, ChordType.DIMINISHED, null));
            chords.add(new Chord(note, ChordType.AUGMENTED, null));

            chords.add(new Chord(note, ChordType.MAJOR_SEVENTH, null));
            chords.add(new Chord(note, ChordType.MINOR_SEVENTH, null));
            chords.add(new Chord(note, ChordType.DOMINANT_SEVENTH, null));
            chords.add(new Chord(note, ChordType.HALF_DIMINISHED_SEVENTH, null));
            chords.add(new Chord(note, ChordType.FULLY_DIMINISHED_SEVEN, null));
            chords.add(new Chord(note, ChordType.MINOR_MAJOR_SEVENTH, null));

            note = ((NoteHolder)circleIterator.next().getValue()).getNote(CircleOfFifths.Direction.UP);
        }

    }

    @Override
    public Chord pickChord() {
        Random r = new Random();
        int randomInt = r.nextInt(chords.size());
        return chords.get(randomInt);
    }
}
