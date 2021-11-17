package model.conceptOfChords;

import model.conceptOfNote.Note;
import model.conceptOfScale.ScaleDegree;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static model.conceptOfNote.Note.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ChordTest {

    @Test
    public void testChord(){
        Chord cMaj = new Chord(C, ChordType.MAJOR, null);
        Chord cMin = new Chord(C, ChordType.MINOR, null);
        Chord cMaj7 = new Chord(C, ChordType.MAJOR_SEVENTH, null);
        Chord cMin7 = new Chord(C, ChordType.MINOR_SEVENTH, null);
        Chord cDom7 = new Chord(C, ChordType.DOMINANT_SEVENTH, null);

        assertNotes(cMaj.getNotes(), Arrays.asList(C, E, G));
        assertNotes(cMin.getNotes(), Arrays.asList(C, E_FLAT, G));
        assertNotes(cMaj7.getNotes(), Arrays.asList(C, E, G, B));
        assertNotes(cMin7.getNotes(), Arrays.asList(C, E_FLAT, G, B_FLAT));
        assertNotes(cDom7.getNotes(), Arrays.asList(C, E, G, B_FLAT));

    }

    private void assertNotes(List<Note> actual, List<Note> expected){
        for(Note expectedNote : expected){
            Assertions.assertThat(actual.contains(expectedNote)).isTrue();
        }
        Assertions.assertThat(actual.size()).isEqualTo(expected.size());
    }
}