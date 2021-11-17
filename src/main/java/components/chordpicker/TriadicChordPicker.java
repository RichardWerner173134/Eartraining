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

public class TriadicChordPicker implements IChordPicker{
    private List<Chord> chords;
    private int currentChordPointer;

    private static TriadicChordPicker instance;

    public static TriadicChordPicker getInstance(){
        if(instance == null){
            instance = new TriadicChordPicker();
        }
        return instance;
    }

    private TriadicChordPicker() {
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
            note = ((NoteHolder)circleIterator.next().getValue()).getNote(CircleOfFifths.Direction.UP);
        }

    }

    @Override
    public Chord pickChord() {
        Random r = new Random();
        currentChordPointer = r.nextInt(chords.size());
        return chords.get(currentChordPointer);
    }

    @Override
    public Chord getCurrentChord() {
        return chords.get(currentChordPointer);
    }
}
