package components.chordpicker;

import model.conceptOfChords.Chord;
import model.conceptOfChords.voicing.ChordVoicing;

import java.util.List;
import java.util.Random;

public abstract class AbstractChordPicker implements IChordPicker{
    protected List<Chord> chords;
    protected int currentChordPointer;

    protected int currentVoicingPointer;

    private Random r;

    public AbstractChordPicker() {
        r = new Random();
    }

    @Override
    public void pickChord() {
        currentChordPointer = r.nextInt(chords.size());
    }

    @Override
    public Chord getCurrentChord() {
        return chords.get(currentChordPointer);
    }

    @Override
    public void pickVoicing() {
        currentVoicingPointer = r.nextInt(getCurrentChord().getChordVoicings().size());
    }

    @Override
    public ChordVoicing.VoicingEnum getCurrentVoicing() {
        return getCurrentChord().getChordVoicings().get(currentVoicingPointer);
    }
}
