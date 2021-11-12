package model.conceptOfIntervals;

import lombok.Getter;
import lombok.Setter;
import model.conceptOfNote.Note;

@Setter
@Getter
public class NoteHolder {
    private Note heldNote;
    private Note enharmonicNote;

    public NoteHolder(Note heldNote) {
        this.heldNote = heldNote;
    }

    public NoteHolder(Note heldNote, Note enharmonicNote) {
        this.heldNote = heldNote;
        this.enharmonicNote = enharmonicNote;
    }
}
