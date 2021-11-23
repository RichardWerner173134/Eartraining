package components.chordpicker;

import model.CircleOfFifths;
import model.CircularLinkedListNode;
import model.conceptOfChords.Chord;
import model.conceptOfIntervals.NoteHolder;
import model.conceptOfNote.Note;

import java.util.ArrayList;
import java.util.Iterator;

import static model.conceptOfChords.ChordType.*;
import static model.conceptOfChords.voicing.ChordVoicing.getVoicingsForChordType;

public class CrazyJazzChordsPicker extends AbstractChordPicker {

    private static CrazyJazzChordsPicker instance;

    public static CrazyJazzChordsPicker getInstance() {
        if (instance == null) {
            try {
                instance = new CrazyJazzChordsPicker();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private CrazyJazzChordsPicker() throws Exception {
        chords = new ArrayList<>();

        CircleOfFifths instance = CircleOfFifths.getInstance();
        instance.setIteratingDirection(CircleOfFifths.Direction.UP);
        instance.resetIterator();

        Iterator<CircularLinkedListNode> circleIterator = instance.getNote().iterator();

        boolean firstRun = true;

        Note note = ((NoteHolder) circleIterator.next().getValue()).getNote(CircleOfFifths.Direction.UP);
        while (note != Note.C || firstRun) {
            firstRun = false;

            chords.add(new Chord(note, MAJOR_NINTH, getVoicingsForChordType(MAJOR_NINTH)));
            chords.add(new Chord(note, MINOR_NINTH, getVoicingsForChordType(MINOR_NINTH)));
            chords.add(new Chord(note, DOMINANT_NINTH_FLAT_NINTH, getVoicingsForChordType(DOMINANT_NINTH_FLAT_NINTH)));
            chords.add(new Chord(note, DOMINANT_NINTH_SHARP_NINTH, getVoicingsForChordType(DOMINANT_NINTH_SHARP_NINTH)));
            chords.add(new Chord(note, DOMINANT_ELEVENTH_SHARP_ELEVEN, getVoicingsForChordType(DOMINANT_ELEVENTH_SHARP_ELEVEN)));

            note = ((NoteHolder) circleIterator.next().getValue()).getNote(CircleOfFifths.Direction.UP);
        }
    }
}

