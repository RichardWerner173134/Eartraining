package model.conceptOfChords;

import lombok.Getter;
import model.conceptOfScale.ScaleDegree;

import java.util.Arrays;
import java.util.List;

import static model.conceptOfScale.ScaleDegree.*;

@Getter
public enum ChordType {

    // triads
    MAJOR(Arrays.asList(ROOT, NATURAL_THIRD, FIFTH)),
    MINOR(Arrays.asList(ROOT, FLAT_THIRD, FIFTH)),
    DIMINISHED(Arrays.asList(ROOT, FLAT_THIRD, FLAT_FIFTH)),
    AUGMENTED(Arrays.asList(ROOT, NATURAL_THIRD, SHARP_FIFTH)),

    // seventh chords
    MAJOR_SEVENTH(Arrays.asList(ROOT, NATURAL_THIRD, FIFTH, NATURAL_SEVENTH)),
    MINOR_SEVENTH(Arrays.asList(ROOT, FLAT_THIRD, FIFTH, FLAT_SEVENTH)),
    DOMINANT_SEVENTH(Arrays.asList(ROOT, NATURAL_THIRD, FIFTH, FLAT_SEVENTH)),

    HALF_DIMINISHED_SEVENTH(Arrays.asList(ROOT, FLAT_THIRD, FLAT_FIFTH, FLAT_SEVENTH)),
    FULLY_DIMINISHED_SEVEN(Arrays.asList(ROOT, FLAT_THIRD, FLAT_FIFTH, DOUBLE_DIMINISHED_SEVENTH)),

    MINOR_MAJOR_SEVENTH(Arrays.asList(ROOT, FLAT_THIRD, FIFTH, NATURAL_SEVENTH)),

    MAJOR_NINTH(Arrays.asList(ROOT, NATURAL_THIRD, FIFTH, NATURAL_SEVENTH, NATURAL_SECOND)),
    MINOR_NINTH(Arrays.asList(ROOT, FLAT_THIRD, FIFTH, FLAT_SEVENTH, NATURAL_SECOND)),

    DOMINANT_NINTH_FLAT_NINTH(Arrays.asList(ROOT, NATURAL_THIRD, FIFTH, FLAT_SEVENTH, FLAT_NINE)),
    DOMINANT_NINTH_SHARP_NINTH(Arrays.asList(ROOT, NATURAL_THIRD, FIFTH, FLAT_SEVENTH, SHARP_NINE)),

    DOMINANT_ELEVENTH_SHARP_ELEVEN(Arrays.asList(ROOT, NATURAL_THIRD, FIFTH, FLAT_SEVENTH, SHARP_NINE, SHARP_FOURTH));

    private Tonality tonality;
    private List<ScaleDegree> scaleDegrees;

    private ChordType(List<ScaleDegree> scaleDegrees) {
        this.scaleDegrees = scaleDegrees;
        try {
            this.tonality = calculateTonality(scaleDegrees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Tonality calculateTonality(List<ScaleDegree> scaleDegrees) throws Exception {
        if(scaleDegrees.contains(NATURAL_THIRD) && scaleDegrees.contains(FIFTH)){
            return Tonality.MAJOR;
        }
        if(scaleDegrees.contains(FLAT_THIRD) && scaleDegrees.contains(FIFTH)){
            return Tonality.MINOR;
        }
        if(scaleDegrees.contains(FLAT_THIRD) && scaleDegrees.contains(FLAT_FIFTH)){
            return Tonality.DIMINISHED;
        }
        if(scaleDegrees.contains(NATURAL_THIRD) && scaleDegrees.contains(SHARP_FIFTH)) {
            return Tonality.AUGMENTED;
        }
        throw new Exception("Cant calculate Tonality");
    }
}
