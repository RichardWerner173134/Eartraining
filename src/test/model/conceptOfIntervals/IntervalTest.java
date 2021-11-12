package model.conceptOfIntervals;

import model.conceptOfNote.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IntervalTest {

    @Test
    public void getNoteFromNoteAndInterval(){
        Note result1 = null;
        Note result2 = null;
        Note result3 = null;
        Note result4 = null;
        Note result5 = null;
        Note result6 = null;
        Note result7 = null;
        Note result8 = null;
        Note result9 = null;
        Note result10 = null;
        Note result11 = null;
        Note result12 = null;
        try {
            result1 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.MINOR_SECOND);
            result2 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.MAJOR_SECOND);
            result3 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.MINOR_THIRD);
            result4 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.MAJOR_THIRD);
            result5 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.PERFECT_FOURTH);
            result6 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.AUGMENTED_FOURTH);
            result7 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.PERFECT_FIFTH);
            result8 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.MINOR_SIXTH);
            result9 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.MAJOR_SIXTH);
            result10 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.MINOR_SEVENTH);
            result11 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.MAJOR_SEVENTH);
            result12 = Interval.getNoteFromNoteAndInterval(Note.C, Interval.PERFECT_OCTAVE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assertions.assertThat(Note.areEqual(result1, Note.D_FLAT)).isTrue();
        Assertions.assertThat(Note.areEqual(result2, Note.D)).isTrue();
        Assertions.assertThat(Note.areEqual(result3, Note.E_FLAT)).isTrue();
        Assertions.assertThat(Note.areEqual(result4, Note.E )).isTrue();
        Assertions.assertThat(Note.areEqual(result5, Note.F )).isTrue();
        Assertions.assertThat(Note.areEqual(result6, Note.F_SHARP)).isTrue();
        Assertions.assertThat(Note.areEqual(result7, Note.G)).isTrue();
        Assertions.assertThat(Note.areEqual(result8, Note.A_FLAT)).isTrue();
        Assertions.assertThat(Note.areEqual(result9, Note.A)).isTrue();
        Assertions.assertThat(Note.areEqual(result10, Note.B_FLAT)).isTrue();
        Assertions.assertThat(Note.areEqual(result11, Note.B)).isTrue();
        Assertions.assertThat(Note.areEqual(result12, Note.C)).isTrue();
    }

    @Test
    public void getONoteFromNoteAndInterval_intervals_in_one_octave(){
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
            noteFromNoteAndInterval1 = Interval.getONoteFromNoteAndInterval(c, Interval.MAJOR_THIRD);
            noteFromNoteAndInterval2 = Interval.getONoteFromNoteAndInterval(c, Interval.MAJOR_SEVENTH);
            noteFromNoteAndInterval3 = Interval.getONoteFromNoteAndInterval(c, Interval.PERFECT_FIFTH);
            noteFromNoteAndInterval4 = Interval.getONoteFromNoteAndInterval(c, Interval.MAJOR_SIXTH);
            noteFromNoteAndInterval5 = Interval.getONoteFromNoteAndInterval(c, Interval.MINOR_THIRD);
            noteFromNoteAndInterval6 = Interval.getONoteFromNoteAndInterval(c, Interval.AUGMENTED_FOURTH);
            noteFromNoteAndInterval7 = Interval.getONoteFromNoteAndInterval(c, Interval.MINOR_SIXTH);
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
    public void get0NoteFromNoteAndInterval_dSharp(){
        ONote dFlat = new ONote(Note.D_FLAT, Octave.FOUR);
        ONote f = new ONote(Note.F, Octave.FOUR);
        ONote gFlat = new ONote(Note.G_FLAT, Octave.FOUR);

        ONote noteFromNoteAndInterval1 = null;
        ONote noteFromNoteAndInterval2 = null;

        try {
            noteFromNoteAndInterval1 = Interval.getONoteFromNoteAndInterval(dFlat, Interval.MAJOR_THIRD);
            noteFromNoteAndInterval2 = Interval.getONoteFromNoteAndInterval(dFlat, Interval.PERFECT_FOURTH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean areEqual1 = ONote.areEqual(f, noteFromNoteAndInterval1);
        boolean areEqual2 = ONote.areEqual(gFlat, noteFromNoteAndInterval2);

        Assertions.assertThat(areEqual1).isTrue();
        Assertions.assertThat(areEqual2).isTrue();
    }
}