package model.conceptOfScale;

import lombok.Getter;
import model.conceptOfIntervals.Interval;

@Getter
public enum ScaleDegree{
    ROOT(Interval.PERFECT_UNISON),
    SECOND(Interval.MAJOR_SECOND),
    THIRD(Interval.MAJOR_THIRD),
    FOURTH(Interval.PERFECT_FOURTH),
    FIFTH(Interval.PERFECT_FIFTH),
    SIXTH(Interval.MAJOR_SIXTH),
    SEVENTH(Interval.MAJOR_SEVENTH),

    FLAT_SECOND(Interval.MINOR_SECOND),//FLAT_NINE
    SHARP_SECOND(Interval.MINOR_THIRD),//SHARP_NINE
    FLAT_THIRD(Interval.MINOR_THIRD),
    SHARP_FOURTH(Interval.AUGMENTED_FOURTH),
    FLAT_FIFTH(Interval.DIMINISHED_FIFTH),
    SHARP_FIFTH(Interval.MINOR_SIXTH),
    FLAT_SIXTH(Interval.MINOR_SIXTH),
    FLAT_SEVENTH(Interval.MINOR_SEVENTH);


    private Interval interval;

    private ScaleDegree(Interval interval){
        this.interval = interval;
    }
}
