package model.conceptOfNote;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NoteTest {

    @Test
    public void noteToInt(){
        int n1 = Note.noteToInt(Note.C);
        int n2 = Note.noteToInt(Note.C_SHARP);
        int n3 = Note.noteToInt(Note.C_FLAT);
        int n4 = Note.noteToInt(Note.D);
        int n5 = Note.noteToInt(Note.E);
        int n6 = Note.noteToInt(Note.F);
        int n7 = Note.noteToInt(Note.G);
        int n8 = Note.noteToInt(Note.A);
        int n9 = Note.noteToInt(Note.B);
        int n10 = Note.noteToInt(Note.B_SHARP);

        Assertions.assertThat(n1).isEqualTo(0);
        Assertions.assertThat(n2).isEqualTo(1);
        Assertions.assertThat(n3).isEqualTo(11);
        Assertions.assertThat(n4).isEqualTo(2);
        Assertions.assertThat(n5).isEqualTo(4);
        Assertions.assertThat(n6).isEqualTo(5);
        Assertions.assertThat(n7).isEqualTo(7);
        Assertions.assertThat(n8).isEqualTo(9);
        Assertions.assertThat(n9).isEqualTo(11);
        Assertions.assertThat(n10).isEqualTo(0);

    }

    @Test
    public void isEnharmonic_accidentals_mixedUp (){
        // yes
        boolean enharmonic1 = Note.isEnharmonic(Note.C, Note.D_DOUBLE_FLAT);
        boolean enharmonic2 = Note.isEnharmonic(Note.C_SHARP, Note.D_FLAT);
        boolean enharmonic3 = Note.isEnharmonic(Note.C_DOUBLE_SHARP, Note.D);
        boolean enharmonic4 = Note.isEnharmonic(Note.C, Note.B_SHARP);

        // no
        boolean enharmonic5 = Note.isEnharmonic(Note.C, Note.F_SHARP);
        boolean enharmonic6 = Note.isEnharmonic(Note.A_FLAT, Note.A_DOUBLE_FLAT);
        boolean enharmonic7 = Note.isEnharmonic(Note.G_SHARP, Note.B);

        Assertions.assertThat(enharmonic1).isTrue();
        Assertions.assertThat(enharmonic2).isTrue();
        Assertions.assertThat(enharmonic3).isTrue();
        Assertions.assertThat(enharmonic4).isTrue();

        Assertions.assertThat(enharmonic5).isFalse();
        Assertions.assertThat(enharmonic6).isFalse();
        Assertions.assertThat(enharmonic7).isFalse();
    }
}