package model.conceptOfNote;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NoteTest {

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