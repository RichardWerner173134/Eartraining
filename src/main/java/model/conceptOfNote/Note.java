package model.conceptOfNote;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static model.conceptOfNote.NoteAccidental.*;

@Getter
public enum Note {

    C_DOUBLE_FLAT(NoteLetter.C, DOUBLE_FLAT),
    C_FLAT(NoteLetter.C, FLAT),
    C(NoteLetter.C, NATURAL),
    C_SHARP(NoteLetter.C, SHARP),
    C_DOUBLE_SHARP(NoteLetter.C, DOUBLE_SHARP),

    D_DOUBLE_FLAT(NoteLetter.D, DOUBLE_FLAT),
    D_FLAT(NoteLetter.D, FLAT),
    D(NoteLetter.D, NATURAL),
    D_SHARP(NoteLetter.D, SHARP),
    D_DOUBLE_SHARP(NoteLetter.D, DOUBLE_SHARP),

    E_DOUBLE_FLAT(NoteLetter.E, DOUBLE_FLAT),
    E_FLAT(NoteLetter.E, FLAT),
    E(NoteLetter.E, NATURAL),
    E_SHARP(NoteLetter.E, SHARP),
    E_DOUBLE_SHARP(NoteLetter.E, DOUBLE_SHARP),

    F_DOUBLE_FLAT(NoteLetter.F, DOUBLE_FLAT),
    F_FLAT(NoteLetter.F, FLAT),
    F(NoteLetter.F, NATURAL),
    F_SHARP(NoteLetter.F, SHARP),
    F_DOUBLE_SHARP(NoteLetter.F, DOUBLE_SHARP),

    G_DOUBLE_FLAT(NoteLetter.G, DOUBLE_FLAT),
    G_FLAT(NoteLetter.G, FLAT),
    G(NoteLetter.G, NATURAL),
    G_SHARP(NoteLetter.G, SHARP),
    G_DOUBLE_SHARP(NoteLetter.G, DOUBLE_SHARP),

    A_DOUBLE_FLAT(NoteLetter.A, DOUBLE_FLAT),
    A_FLAT(NoteLetter.A, FLAT),
    A(NoteLetter.A, NATURAL),
    A_SHARP(NoteLetter.A, SHARP),
    A_DOUBLE_SHARP(NoteLetter.A, DOUBLE_SHARP),

    B_DOUBLE_FLAT(NoteLetter.B, DOUBLE_FLAT),
    B_FLAT(NoteLetter.B, FLAT),
    B(NoteLetter.B, NATURAL),
    B_SHARP(NoteLetter.B, SHARP),
    B_DOUBLE_SHARP(NoteLetter.B, DOUBLE_SHARP);

    private NoteLetter letter;
    private NoteAccidental accidental;

    private Note(NoteLetter letter, NoteAccidental accidental){
        this.letter = letter;
        this.accidental = accidental;
    }

    public static List<Note> getAllNotes(){
        return Arrays.asList(
                C_DOUBLE_FLAT, C_FLAT, C, C_SHARP, C_DOUBLE_SHARP,
                D_DOUBLE_FLAT, D_FLAT, D, D_SHARP, D_DOUBLE_SHARP,
                E_DOUBLE_FLAT, E_FLAT, E, E_SHARP, E_DOUBLE_SHARP,
                F_DOUBLE_FLAT, F_FLAT, F, F_SHARP, F_DOUBLE_SHARP,
                G_DOUBLE_FLAT, G_FLAT, G, G_SHARP, G_DOUBLE_SHARP,
                A_DOUBLE_FLAT, A_FLAT, A, A_SHARP, A_DOUBLE_SHARP,
                B_DOUBLE_FLAT, B_FLAT, B, B_SHARP, B_DOUBLE_SHARP
        );
    }

    public static boolean isEnharmonic(Note n1, Note n2){
        int pos1 = n1.getLetter().getPos();
        int pos2 = n2.getLetter().getPos();
        pos1 += n1.getAccidental().getDisplacement();
        pos2 += n2.getAccidental().getDisplacement();

        return pos1 % 12 == pos2 % 12;
    }
}
