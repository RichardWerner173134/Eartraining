package model;

import lombok.Getter;
import model.conceptOfIntervals.Interval;
import model.conceptOfIntervals.NoteHolder;
import model.conceptOfNote.Note;

import java.util.Iterator;

@Getter
public class CircleOfFifths implements Iterator {
    private static CircleOfFifths circleOfFifths; // singleton

    private CircularLinkedListNode<NoteHolder> note; // linkedList
    private Direction iteratingDirection;

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
        iteratingDirection = Direction.UP;

        note = new CircularLinkedListNode<>(new NoteHolder(Note.C, Direction.UP), null, null);

        // calculate CircleOfFifths in Fifths up
        produceFifthInterval(Direction.UP);

        // remember last note going up in fifths
        CircularLinkedListNode<NoteHolder> lastUp = note;

        // go back to C
        while(!Note.areEqual(this.note.getValue().getNote(Direction.UP), Note.C)){
            this.note = this.note.getPrevious();
        }

        // calculate CircleOfFifths in Fifths down
        produceFifthInterval(Direction.DOWN);

        // remember last note going gown in fifths
        CircularLinkedListNode<NoteHolder> lastDown = note;

        // merge notes and link it with its neightbours to a circle
        mergeNodesToOne(lastUp, lastDown);
    }

    public void printCircle() {
        CircularLinkedListNode last = note;
        do {
            System.out.println(note.getValue().toString());
            this.note = note.getNext();
        } while(note != last);
    }

    private void mergeNodesToOne(CircularLinkedListNode<NoteHolder> lastUp, CircularLinkedListNode<NoteHolder> lastDown) {
        CircularLinkedListNode dFlat = lastDown.getNext();
        dFlat.setPrevious(lastUp);
        lastUp.getValue().setNote(lastDown.getValue().getNote(Direction.DOWN), Direction.DOWN);
        lastUp.setNext(dFlat);
        note = lastUp;
    }

    private void produceFifthInterval(Direction direction){
        Interval interval = direction == Direction.UP ? Interval.PERFECT_FIFTH : Interval.PERFECT_FOURTH;
        boolean firstRun = true;

        while(true){
            // stop at the middle
            if(!firstRun &&
                    (Note.isEnharmonic(note.getValue().getNote(Direction.UP), Note.F_SHARP)
                            || Note.isEnharmonic(note.getValue().getNote(Direction.DOWN), Note.G_FLAT))){
                break;
            }
            firstRun = false;

            Note newNote = null;
            try {
                newNote = Interval.getNoteFromNoteAndInterval(note.getValue().getNote(Direction.UP), interval);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // produce new Nodes holding a Note
            if(direction == Direction.UP) {
                CircularLinkedListNode<NoteHolder> fifthUp = new CircularLinkedListNode<>(new NoteHolder(newNote, Direction.UP), null, note);
                note.setNext(fifthUp);
                note = note.getNext();
            } else {
                CircularLinkedListNode<NoteHolder> fifthDown = new CircularLinkedListNode<>(new NoteHolder(newNote, Direction.DOWN), note, null);
                note.setPrevious(fifthDown);
                note = note.getPrevious();
            }
        }
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Object next() {
        if(iteratingDirection == Direction.UP){
            note = note.getNext();
        } else {
            note = note.getPrevious();
        }
        return note;
    }

    public void resetIterator(){
        if(iteratingDirection == Direction.UP){
            while(note.getValue().getNote(Direction.UP) != Note.F){
                note = note.getNext();
            }
        } else {
            while(note.getValue().getNote(Direction.DOWN) != Note.G){
                note = note.getNext();
            }
        }
    }

    public void setIteratingDirection(Direction iteratingDirection) {
        this.iteratingDirection = iteratingDirection;
    }

    public enum Direction{
        UP,
        DOWN;
    }
}
