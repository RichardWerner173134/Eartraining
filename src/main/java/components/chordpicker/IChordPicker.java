package components.chordpicker;

import model.conceptOfChords.Chord;
import model.conceptOfChords.voicing.ChordVoicing;

public interface IChordPicker {
    void pickChord();
    Chord getCurrentChord();

    void pickVoicing();
    ChordVoicing.VoicingEnum getCurrentVoicing();
}
