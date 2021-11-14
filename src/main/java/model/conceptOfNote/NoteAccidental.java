package model.conceptOfNote;

import lombok.Getter;

@Getter
public enum NoteAccidental {
    NATURAL(0),
    SHARP("#", 1),
    FLAT("b", -1),
    DOUBLE_FLAT("B", -2),
    DOUBLE_SHARP("##", +2);

    private String accidental;
    private int displacement;

    private NoteAccidental(String accidental, int displacement){
        this.accidental = accidental;
        this.displacement = displacement;
    }

    private NoteAccidental(int displacement){
        this.displacement = displacement;
    }
}
