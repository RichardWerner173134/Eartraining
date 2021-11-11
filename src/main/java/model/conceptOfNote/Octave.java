package model.conceptOfNote;

import java.util.Arrays;
import java.util.List;

public enum Octave {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    private int number;

    private Octave(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public static List<Octave> getOrderedOctaves(){
        return Arrays.asList(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT);
    }
}
