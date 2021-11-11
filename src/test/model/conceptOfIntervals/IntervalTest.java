package model.conceptOfIntervals;

import model.conceptOfNote.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IntervalTest {

    @Test
    public void getNoteFromNoteAndInterval_intervals_in_one_octave(){
        ONote c = new ONote(Note.C, Octave.FOUR);
        ONote e = new ONote(Note.E, Octave.FOUR);
        ONote b = new ONote(Note.B, Octave.FOUR);
        ONote g = new ONote(Note.G, Octave.FOUR);
        ONote a = new ONote(Note.A, Octave.FOUR);

        ONote eFlat = new ONote(Note.E_FLAT, Octave.FOUR);
        ONote fSharp = new ONote(Note.F_SHARP, Octave.FOUR);
        ONote aFlat = new ONote(Note.A_FLAT, Octave.FOUR);

        ONote noteFromNoteAndInterval1 = null;
        ONote noteFromNoteAndInterval2 = null;
        ONote noteFromNoteAndInterval3 = null;
        ONote noteFromNoteAndInterval4 = null;
        ONote noteFromNoteAndInterval5 = null;
        ONote noteFromNoteAndInterval6 = null;
        ONote noteFromNoteAndInterval7 = null;

        try {
            noteFromNoteAndInterval1 = Interval.getNoteFromNoteAndInterval(c, Interval.MAJOR_THIRD);
            noteFromNoteAndInterval2 = Interval.getNoteFromNoteAndInterval(c, Interval.MAJOR_SEVENTH);
            noteFromNoteAndInterval3 = Interval.getNoteFromNoteAndInterval(c, Interval.PERFECT_FIFTH);
            noteFromNoteAndInterval4 = Interval.getNoteFromNoteAndInterval(c, Interval.MAJOR_SIXTH);
            noteFromNoteAndInterval5 = Interval.getNoteFromNoteAndInterval(c, Interval.MINOR_THIRD);
            noteFromNoteAndInterval6 = Interval.getNoteFromNoteAndInterval(c, Interval.AUGMENTED_FOURTH);
            noteFromNoteAndInterval7 = Interval.getNoteFromNoteAndInterval(c, Interval.MINOR_SIXTH);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        boolean areEqual1 = ONote.areEqual(e, noteFromNoteAndInterval1);
        boolean areEqual2 = ONote.areEqual(b, noteFromNoteAndInterval2);
        boolean areEqual3 = ONote.areEqual(g, noteFromNoteAndInterval3);
        boolean areEqual4 = ONote.areEqual(a, noteFromNoteAndInterval4);
        boolean areEqual5 = ONote.areEqual(eFlat, noteFromNoteAndInterval5);
        boolean areEqual6 = ONote.areEqual(fSharp, noteFromNoteAndInterval6);
        boolean areEqual7 = ONote.areEqual(aFlat, noteFromNoteAndInterval7);

        Assertions.assertThat(areEqual1).isTrue();
        Assertions.assertThat(areEqual2).isTrue();
        Assertions.assertThat(areEqual3).isTrue();
        Assertions.assertThat(areEqual4).isTrue();
        Assertions.assertThat(areEqual5).isTrue();
        Assertions.assertThat(areEqual6).isTrue();
        Assertions.assertThat(areEqual7).isTrue();
    }

    @Test
    public void getNoteFromNoteAndInterval_dSharp(){
        ONote dFlat = new ONote(Note.D_FLAT, Octave.FOUR);
        ONote f = new ONote(Note.F, Octave.FOUR);
        ONote gFlat = new ONote(Note.G_FLAT, Octave.FOUR);

        ONote noteFromNoteAndInterval1 = null;
        ONote noteFromNoteAndInterval2 = null;

        try {
            noteFromNoteAndInterval1 = Interval.getNoteFromNoteAndInterval(dFlat, Interval.MAJOR_THIRD);
            noteFromNoteAndInterval2 = Interval.getNoteFromNoteAndInterval(dFlat, Interval.PERFECT_FOURTH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean areEqual1 = ONote.areEqual(f, noteFromNoteAndInterval1);
        boolean areEqual2 = ONote.areEqual(gFlat, noteFromNoteAndInterval2);

        Assertions.assertThat(areEqual1).isTrue();
        Assertions.assertThat(areEqual2).isTrue();

    }
}