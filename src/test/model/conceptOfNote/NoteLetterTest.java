package model.conceptOfNote;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Iterator;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class NoteLetterTest {

    @Test
    public void getOrderedNoteLetters_is_correct(){
        List<NoteLetter> orderedNoteLetters = NoteLetter.getOrderedNoteLetters();

        Iterator<NoteLetter> iterator = orderedNoteLetters.iterator();
        NoteLetter c = iterator.next();
        NoteLetter d = iterator.next();
        NoteLetter e = iterator.next();
        NoteLetter f = iterator.next();
        NoteLetter g = iterator.next();
        NoteLetter a = iterator.next();
        NoteLetter b = iterator.next();

        Assertions.assertThat(c).isEqualTo(NoteLetter.C);
        Assertions.assertThat(d).isEqualTo(NoteLetter.D);
        Assertions.assertThat(e).isEqualTo(NoteLetter.E);
        Assertions.assertThat(f).isEqualTo(NoteLetter.F);
        Assertions.assertThat(g).isEqualTo(NoteLetter.G);
        Assertions.assertThat(a).isEqualTo(NoteLetter.A);
        Assertions.assertThat(b).isEqualTo(NoteLetter.B);
    }

    @Test
    public void getOrderedNoteLettersBeginningFromNoteLetter_is_correct(){
        List<NoteLetter> orderedNoteLetterBeginningFromNoteLetter = NoteLetter.getOrderedNoteLettersBeginningFromNoteLetter(NoteLetter.F);
        Iterator<NoteLetter> iterator = orderedNoteLetterBeginningFromNoteLetter.iterator();

        NoteLetter f = iterator.next();
        NoteLetter g = iterator.next();
        NoteLetter a = iterator.next();
        NoteLetter b = iterator.next();
        NoteLetter c = iterator.next();
        NoteLetter d = iterator.next();
        NoteLetter e = iterator.next();

        Assertions.assertThat(c).isEqualTo(NoteLetter.C);
        Assertions.assertThat(d).isEqualTo(NoteLetter.D);
        Assertions.assertThat(e).isEqualTo(NoteLetter.E);
        Assertions.assertThat(f).isEqualTo(NoteLetter.F);
        Assertions.assertThat(g).isEqualTo(NoteLetter.G);
        Assertions.assertThat(a).isEqualTo(NoteLetter.A);
        Assertions.assertThat(b).isEqualTo(NoteLetter.B);
    }
}