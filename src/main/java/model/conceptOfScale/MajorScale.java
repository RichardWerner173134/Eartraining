package model.conceptOfScale;

import model.conceptOfChords.Tonality;
import model.conceptOfIntervals.Interval;
import model.conceptOfNote.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorScale extends Scale{
    public MajorScale(Note rootNote) {
        List<Note> notes = null;
        try {
            notes = produceNotesForMajorScale(rootNote);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.rootNote = rootNote;
        this.tonality = Tonality.MAJOR;
        this.notes = notes;
    }

    private static List<Interval> getMajorScaleIntervals() {
        return Arrays.asList(
                Interval.PERFECT_UNISON,
                Interval.MAJOR_SECOND,
                Interval.MAJOR_THIRD,
                Interval.PERFECT_FOURTH,
                Interval.PERFECT_FIFTH,
                Interval.MAJOR_SIXTH,
                Interval.MAJOR_SEVENTH
        );
    }

    private static List<Note> produceNotesForMajorScale(Note note) throws Exception {
        ArrayList<Note> notes = new ArrayList<>();
        for(Interval i : getMajorScaleIntervals()){
            notes.add(Interval.getNoteFromNoteAndInterval(note, i));
        }
        return notes;
    }
}
