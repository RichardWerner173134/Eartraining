package model;

import model.conceptOfIntervals.NoteHolder;
import model.conceptOfNote.Note;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CircleOfFifthsTest {

    @Test
    public void testInitialization_clockwise(){
        CircleOfFifths instance = CircleOfFifths.getInstance();

        List<Note> notes = Arrays.asList(
                Note.C,
                Note.G,
                Note.D,
                Note.A,
                Note.E,
                Note.B,
                Note.F_SHARP,
                Note.D_FLAT,
                Note.A_FLAT,
                Note.E_FLAT,
                Note.B_FLAT,
                Note.F,
                Note.C
        );

        Iterator<CircularLinkedListNode<NoteHolder>> actualIterator = instance.getNote().iterator();
        Iterator<Note> expectedIterator = notes.iterator();
        int i = 0;
        while(actualIterator.hasNext() && expectedIterator.hasNext()){
            CircularLinkedListNode<NoteHolder> actual = actualIterator.next();
            Note expected = expectedIterator.next();

            assertNoteHolderWithNote(expected, CircleOfFifths.Direction.UP, actual.getValue());
        }
    }

    @Test
    public void testInitialization_counterClockwise(){
        CircleOfFifths instance = CircleOfFifths.getInstance();
        instance.setIteratingDirection(CircleOfFifths.Direction.DOWN);
        instance.resetIterator();

        List<Note> notes = Arrays.asList(
                Note.C,
                Note.F,
                Note.B_FLAT,
                Note.E_FLAT,
                Note.A_FLAT,
                Note.D_FLAT,
                Note.G_FLAT,
                Note.B,
                Note.E,
                Note.A,
                Note.D,
                Note.G,
                Note.C
        );

        Iterator<CircularLinkedListNode<NoteHolder>> actualIterator = instance.getNote().iterator();
        Iterator<Note> expectedIterator = notes.iterator();
        int i = 0;
        while(actualIterator.hasNext() && expectedIterator.hasNext()){
            CircularLinkedListNode<NoteHolder> actual = actualIterator.next();
            Note expected = expectedIterator.next();

            assertNoteHolderWithNote(expected, CircleOfFifths.Direction.DOWN, actual.getValue());
        }
    }

    private void assertNoteHolderWithNote(Note expected, CircleOfFifths.Direction direction, NoteHolder actual){
        Assertions.assertThat(expected).isEqualTo(actual.getNote(direction));
    }
}