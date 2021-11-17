package model.conceptOfChords;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.conceptOfIntervals.Interval;
import model.conceptOfNote.Note;
import model.conceptOfScale.ScaleDegree;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Chord {
    private Note rootNote;
    private List<Note> notes;
    private ChordType chordType;
    private List<ChordVoicing> chordVoicings;

    public Chord(Note rootNote, ChordType chordType, List<ChordVoicing> chordVoicings) {
        this.rootNote = rootNote;
        this.chordType = chordType;
        this.chordVoicings = chordVoicings;
        try {
            this.notes = produceNotesForChord(rootNote, chordType.getScaleDegrees());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Note> produceNotesForChord(Note rootNote, List<ScaleDegree> scaleDegrees) throws Exception {
        List<Note> notes = new ArrayList<>();
        for(ScaleDegree scaleDegree : scaleDegrees){
            notes.add(Interval.getNoteFromNoteAndInterval(rootNote, scaleDegree.getInterval()));
        }
        return notes;
    }
}
