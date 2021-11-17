package components.chordpicker;

import model.conceptOfChords.Chord;

public interface IChordPicker {
    Chord pickChord();
    Chord getCurrentChord();
}
