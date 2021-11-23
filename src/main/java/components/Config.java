package components;


import components.chordpicker.*;
import lombok.Getter;

public class Config {
    private static Config config;

    private NumberOfNotes numberOfNotes;
    private ScaleDegreeMix scaleDegreeMix;
    private NumberOfOctaves numberOfOctaves;

    private ChordMix chordMix;

    private Config(){
        numberOfNotes = NumberOfNotes.TWO;
        scaleDegreeMix = ScaleDegreeMix.ONE_TWO_THREE_FOUR_FIVE;
        numberOfOctaves = NumberOfOctaves.ONE_OCTAVE;
        chordMix = ChordMix.ALL_CHORDS;
    }

    public static Config getInstance(){
        if(config == null){
            config = new Config();
        }
        return config;
    }

    public void setNumberOfOctaves(NumberOfOctaves number){
        this.numberOfOctaves = number;
    }

    public void setNumberOfNotes(NumberOfNotes number){
        numberOfNotes = number;
    }

    public void setScaleDegreeMix(ScaleDegreeMix scaleMix){
        scaleDegreeMix = scaleMix;
    }

    public ScaleDegreeMix getScaleDegreeMix(){
        return scaleDegreeMix;
    }

    public NumberOfNotes getNumberOfNotes(){
        return numberOfNotes;
    }

    public NumberOfOctaves getNumberOfOctaves(){
        return numberOfOctaves;
    }

    public int getMaxNotesLowerRegister(){
        return numberOfOctaves.getMaxNumberOfNotesLowerOctave();
    }

    public int[] getOctaveNumberIntervall(){
        switch (numberOfOctaves) {
            case ONE_OCTAVE:
                return new int[]{4};
            case TWO_OCTAVES:
                return new int[]{4, 5};
            case THREE_OCTAVES:
                return new int[]{3, 4, 5};
        }
        throw new NullPointerException("config not initialized");
    }

    public ChordMix getChordMix(){
        return chordMix;
    }

    public void setChordMix(ChordMix chordMix){
        this.chordMix = chordMix;
    }

    // enums
    public enum NumberOfNotes{

        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5);

        private int numberOfNotes;

        NumberOfNotes(int numberOfNotes){
            this.numberOfNotes = numberOfNotes;
        }

        public String toString(){
            return String.valueOf(this.numberOfNotes);
        }

        public int getValue(){
            return numberOfNotes;
        }
    }

    public enum ScaleDegreeMix{
        ONE_TWO_THREE_FOUR_FIVE(),
        ALL_DIATONIC(),
        CHROMATIC();
    }

    public enum NumberOfOctaves{
        ONE_OCTAVE(1, 5),
        TWO_OCTAVES(2, 5),
        THREE_OCTAVES(3, 2);

        private int numberOfOctaves;
        private int maxNumberOfNotesLowerOctave;

        NumberOfOctaves(int numberOfOctaves, int maxNumberOfNotesLowerOctave){
            this.numberOfOctaves = numberOfOctaves;
            this.maxNumberOfNotesLowerOctave = maxNumberOfNotesLowerOctave;
        }

        public int getNumberOfOctaves(){
            return this.numberOfOctaves;
        }

        public int getMaxNumberOfNotesLowerOctave(){
            return this.maxNumberOfNotesLowerOctave;
        }
    }

    @Getter
    public enum ChordMix {
        ALL_CHORDS(AllChordsPicker.getInstance()),
        TRIADIC_CHORDS(TriadicChordPicker.getInstance()),
        SEVENTH_CHORDS(SeventhsChordPicker.getInstance()),
        CRAZY_JAZZ_CHORDS(CrazyJazzChordsPicker.getInstance());

        private final IChordPicker chordPicker;

        private ChordMix(IChordPicker chordPicker){
            this.chordPicker = chordPicker;
        }
    }
}
