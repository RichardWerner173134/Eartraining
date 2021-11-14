package model.conceptOfNote;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ONoteTest {

    @Test
    public void getAllONotesList(){
        List<ONote> fullONoteList = ONote.getFullONoteList();

        Assertions.assertThat(fullONoteList.size()).isEqualTo(280);
    }

    @Test
    public void isEnharmonic_normal_cases(){
        ONote c3 = new ONote(Note.C, Octave.THREE);
        ONote cDoubleFlat3 = new ONote(Note.D_DOUBLE_FLAT, Octave.THREE);
        ONote d3 = new ONote(Note.D, Octave.THREE);
        ONote gSharp3 = new ONote(Note.G_SHARP, Octave.THREE);
        ONote aFlat3 = new ONote(Note.A_FLAT, Octave.THREE);
        ONote aFlat4 = new ONote(Note.A_FLAT, Octave.FOUR);
        ONote fDoubleFlat3 = new ONote(Note.F_DOUBLE_FLAT, Octave.THREE);
        ONote eFlat3 = new ONote(Note.E_FLAT, Octave.THREE);

        boolean shouldBeFalse1 = ONote.isEnharmonic(c3, d3);
        boolean shouldBeFalse2 = ONote.isEnharmonic(gSharp3, aFlat4);
        boolean shouldBeFalse3 = ONote.isEnharmonic(eFlat3, aFlat3);
        boolean shouldBeTrue1 = ONote.isEnharmonic(aFlat3, gSharp3);
        boolean shouldBeTrue2 = ONote.isEnharmonic(fDoubleFlat3, eFlat3);
        boolean shouldBeTrue3 = ONote.isEnharmonic(cDoubleFlat3, d3);
    }

    @Test
    public void isEnharmonic_octave_border(){
        boolean enharmonic = ONote.isEnharmonic(
                new ONote(Note.B_DOUBLE_SHARP, Octave.THREE),
                new ONote(Note.C_SHARP, Octave.FOUR));

        Assertions.assertThat(enharmonic).isTrue();
    }
}