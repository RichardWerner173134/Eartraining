package model.conceptOfScale;

import lombok.AllArgsConstructor;
import model.conceptOfChords.Tonality;
import model.conceptOfIntervals.Interval;
import model.conceptOfNote.Note;

import java.util.List;

public abstract class Scale {
    protected Note rootNote;
    protected Tonality tonality;
    protected List<Note> notes;

    public String getScaleName() {
        return rootNote.toString();
    }

    public static Note getNoteFromScaleDegree(Note rootNote, ScaleDegree scaleDegree) throws Exception {
        return Interval.getNoteFromNoteAndInterval(rootNote, scaleDegree.getInterval());
    }
}
