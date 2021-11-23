package model.conceptOfScale;

import lombok.Getter;
import model.conceptOfIntervals.Interval;

import static model.conceptOfIntervals.Interval.*;

@Getter
public enum ScaleDegree{
    ROOT(PERFECT_UNISON, "1"),
    NATURAL_SECOND(MAJOR_SECOND, "2"),
    NATURAL_THIRD(MAJOR_THIRD, "3"),
    FOURTH(PERFECT_FOURTH, "4"),
    FIFTH(PERFECT_FIFTH, "5"),
    NATURAL_SIXTH(MAJOR_SIXTH, "6"),
    NATURAL_SEVENTH(MAJOR_SEVENTH, "7"),

    FLAT_NINE(MINOR_SECOND, "b9"),//FLAT_NINE
    SHARP_NINE(MINOR_THIRD, "#9"),//SHARP_NINE
    FLAT_THIRD(MINOR_THIRD, "b3"),
    SHARP_FOURTH(AUGMENTED_FOURTH, "#11"),
    FLAT_FIFTH(DIMINISHED_FIFTH, "b5"),
    SHARP_FIFTH(MINOR_SIXTH, "#5"),
    FLAT_SIXTH(MINOR_SIXTH, "b6"),
    FLAT_SEVENTH(MINOR_SEVENTH, "b7"),
    DOUBLE_DIMINISHED_SEVENTH(MAJOR_SIXTH, "bb7");


    private Interval interval;
    private String name;

    private ScaleDegree(Interval interval, String name){
        this.interval = interval;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
