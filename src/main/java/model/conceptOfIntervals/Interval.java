package model.conceptOfIntervals;

import lombok.Getter;
import model.conceptOfNote.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static model.conceptOfNote.NoteAccidental.*;

@Getter
public enum Interval {
    PERFECT_UNISON(0, 0, NATURAL),

    MINOR_SECOND(1, 1, FLAT),
    MAJOR_SECOND(2, 1, NATURAL),

    MINOR_THIRD(3, 2, FLAT),
    MAJOR_THIRD(4, 2, NATURAL),

    PERFECT_FOURTH(5, 3, NATURAL),
    AUGMENTED_FOURTH(6, 3, SHARP),

    DIMINISHED_FIFTH(6, 4, FLAT),
    PERFECT_FIFTH(7, 4, NATURAL),

    MINOR_SIXTH(8, 5, FLAT),
    MAJOR_SIXTH(9, 5, NATURAL),

    MINOR_SEVENTH(10, 6, FLAT),
    MAJOR_SEVENTH(11, 6, NATURAL),

    PERFECT_OCTAVE(12, 7, NATURAL);

    private int numberOfSteps;
    private int numberOfLetterSteps;
    private NoteAccidental accidental;

    private Interval(int numberOfSteps, int numberOfLetterSteps, NoteAccidental accidental){
        this.numberOfSteps = numberOfSteps;
        this.numberOfLetterSteps = numberOfLetterSteps;
        this.accidental = accidental;
    }

    public static ONote getNoteFromNoteAndInterval(ONote startNote, Interval interval) throws Exception {
        List<ONote> fullONoteList = ONote.getFullONoteList();

        int startNoteInt = ONote.noteToInt(startNote);
        int targetNoteInt = startNoteInt + interval.getNumberOfSteps();

        NoteLetter targetNoteLetter = null;
        Iterator<NoteLetter> iterator = NoteLetter.getOrderedNoteLettersBeginningFromNoteLetter(startNote.getNote().getLetter()).iterator();
        iterator.next(); // discard the first NoteLetter (its the same as startNote.getNote().getLetter()
        for(int i = 0; i < interval.getNumberOfLetterSteps(); i++){
            if(iterator.hasNext()){
                targetNoteLetter = iterator.next();
            }
        }

        NoteLetter a = targetNoteLetter;

        if(targetNoteLetter == null){
            throw new Exception("blablabl");
        }

        Optional<ONote> first = fullONoteList.stream()
                .filter(n -> ONote.noteToInt(n) == targetNoteInt)    // find all Notes, that are enharmoni)
                .filter(n -> n.getNote().getLetter() == a)
                .findFirst();

        return first.orElseThrow(Exception::new);
    }
}
