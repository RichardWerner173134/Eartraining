package model.conceptOfScale;

import lombok.Getter;
import model.conceptOfIntervals.Interval;

import static model.conceptOfIntervals.Interval.*;

@Getter
public enum ScaleDegree{
    ROOT(PERFECT_UNISON),
    NATURAL_SECOND(MAJOR_SECOND),
    NATURAL_THIRD(MAJOR_THIRD),
    FOURTH(PERFECT_FOURTH),
    FIFTH(PERFECT_FIFTH),
    NATURAL_SIXTH(MAJOR_SIXTH),
    NATURAL_SEVENTH(MAJOR_SEVENTH),

    FLAT_SECOND(MINOR_SECOND),//FLAT_NINE
    SHARP_SECOND(MINOR_THIRD),//SHARP_NINE
    FLAT_THIRD(MINOR_THIRD),
    SHARP_FOURTH(AUGMENTED_FOURTH),
    FLAT_FIFTH(DIMINISHED_FIFTH),
    SHARP_FIFTH(MINOR_SIXTH),
    FLAT_SIXTH(MINOR_SIXTH),
    FLAT_SEVENTH(MINOR_SEVENTH),
    DOUBLE_DIMINISHED_SEVENTH(MAJOR_SIXTH);


    private Interval interval;

    private ScaleDegree(Interval interval){
        this.interval = interval;
    }
}
