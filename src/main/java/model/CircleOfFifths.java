package model;

import components.CircularLinkedListNode;
import model.conceptOfIntervals.Interval;
import model.conceptOfIntervals.NoteHolder;
import model.conceptOfNote.Note;

import java.util.Iterator;

public class CircleOfFifths implements Iterable<Note>{

    private CircularLinkedListNode<NoteHolder> note;

    private static CircleOfFifths circleOfFifths;

    private CircleOfFifths(){
        initializeCircleOfFifth();
    }

    public static CircleOfFifths getInstance(){
        if(circleOfFifths == null){
            circleOfFifths = new CircleOfFifths();
        }
        return circleOfFifths;
    }

    private void initializeCircleOfFifth() {
        note = new CircularLinkedListNode<>(new NoteHolder(Note.C), null, null);

        // calculate CircleOfFifths in Fifths up
        jumpInterval(Direction.UP);

        // remember last note
        CircularLinkedListNode<Note> lastUpwards = note;

        // go back to C
        while(!Note.areEqual((Note) note.getPrevious().getValue(), Note.C)){
            note = note.getPrevious();
        }

        // calculate CircleOfFifths in Fifths down
        jumpInterval(Direction.DOWN);



    }

    private void jumpInterval(Direction direction){
        Interval interval = direction == Direction.UP ? Interval.PERFECT_FIFTH : Interval.PERFECT_FOURTH;
        boolean firstRun = true;

        while(true){
            if(!firstRun &&
                    (Note.isEnharmonic(note.getValue(), Note.F_SHARP) || Note.isEnharmonic(note.getValue(), Note.G_FLAT))){
                break;
            }
            firstRun = false;

            Note newNote = null;
            try {
                newNote = Interval.getNoteFromNoteAndInterval(note.getValue(), interval);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(direction == Direction.UP) {
                CircularLinkedListNode<Note> fifthUp = new CircularLinkedListNode<>(newNote, null, note);
                note.setNext(fifthUp);
                note = note.getNext();
            } else {
                CircularLinkedListNode<Note> fifthDown = new CircularLinkedListNode<>(newNote, note, null);
                note.setPrevious(fifthDown);
                note = note.getPrevious();
            }
        }
    }

    @Override
    public Iterator<Note> iterator() {




        return null;
    }

    enum Direction{
        UP,
        DOWN;
    }
}
