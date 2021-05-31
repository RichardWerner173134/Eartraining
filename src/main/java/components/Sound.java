package components;

import java.util.HashMap;

public enum Sound {

    ONE3(1, 3),
    FLAT_TWO3(2, 'b', 3),
    TWO3(2, 3),
    FLAT_THREE3(3, 'b', 3),
    THREE3(3, 3),
    FOUR3(4, 3),
    SHARP_FOUR3(4, '#', 3),
    FIVE3(5, 3),
    FLAT_SIX3(6, 'b', 3),
    SIX3(6, 3),
    FLAT_SEVEN3(7, 'b', 3),
    SEVEN3(7, 3),

    ONE4(1, 4),
    FLAT_TWO4(2, 'b', 4),
    TWO4(2, 4),
    FLAT_THREE4(3, 'b', 4),
    THREE4(3, 4),
    FOUR4(4, 4),
    SHARP_FOUR4(4, '#', 4),
    FIVE4(5, 4),
    FLAT_SIX4(6, 'b', 4),
    SIX4(6, 4),
    FLAT_SEVEN4(7, 'b', 4),
    SEVEN4(7, 4),

    ONE5(1, 5),
    FLAT_TWO5(2, 'b', 5),
    TWO5(2, 5),
    FLAT_THREE5(3, 'b', 5),
    THREE5(3, 5),
    FOUR5(4, 5),
    SHARP_FOUR5(4, '#', 5),
    FIVE5(5, 5),
    FLAT_SIX5(6, 'b', 5),
    SIX5(6, 5),
    FLAT_SEVEN5(7, 'b', 5),
    SEVEN5(7, 5);


    private int scaleDegree;
    private char accidental;
    private int octave;

    Sound(int scaleDegree, int octave){
        this.scaleDegree = scaleDegree;
        this.accidental = 'n';
        this.octave = octave;
    }

    Sound(int scaleDegree, char accidental, int octave){
        this.scaleDegree = scaleDegree;
        this.accidental = accidental;
        this.octave = octave;
    }

    public int getScaleDegree(){
        return this.scaleDegree;
    }

    public char getAccidental(){
        return this.accidental;
    }

    public int getOctave(){
        return this.octave;
    }

    public String getSoundString() throws Exception {
        // we just play sounds from the C Major Scale
        HashMap<Integer, Character> cMajorMap = new HashMap<>();
        cMajorMap.put(1, 'C');
        cMajorMap.put(2, 'D');
        cMajorMap.put(3, 'E');
        cMajorMap.put(4, 'F');
        cMajorMap.put(5, 'G');
        cMajorMap.put(6, 'A');
        cMajorMap.put(7, 'B');

        String note = cMajorMap.get(scaleDegree).toString() + octave;

        if(accidental == 'n'){
            return note;
        } else if(accidental == 'b' || accidental == '#'){
            return note + accidental;
        }
        throw new Exception("Unknown accidental");
    }

    public static Sound getSoundType(int scaleDegree, char accidental, int octave){
        switch(scaleDegree){
            case 1:
                switch(octave) {
                    case 3:
                        return ONE3;
                    case 4:
                        return ONE4;
                    case 5:
                        return ONE5;
                }
            case 2:
                switch(octave) {
                    case 3:
                        if (accidental == 'b') {
                            return FLAT_TWO3;
                        } else {
                            return TWO3;
                        }
                    case 4:
                        if (accidental == 'b') {
                            return FLAT_TWO4;
                        } else {
                            return TWO4;
                        }
                    case 5:
                        if (accidental == 'b') {
                            return FLAT_TWO5;
                        } else {
                            return TWO5;
                        }
                }
            case 3:
                switch(octave) {
                    case 3:
                        if (accidental == 'b') {
                            return FLAT_THREE3;
                        } else {
                            return THREE3;
                        }
                    case 4:
                        if (accidental == 'b') {
                            return FLAT_THREE4;
                        } else {
                            return THREE4;
                        }
                    case 5:
                        if (accidental == 'b') {
                            return FLAT_THREE5;
                        } else {
                            return THREE5;
                        }
                }
            case 4:
                switch(octave) {
                    case 3:
                        if (accidental == '#') {
                            return SHARP_FOUR3;
                        } else {
                            return FOUR3;
                        }
                    case 4:
                        if (accidental == '#') {
                            return SHARP_FOUR4;
                        } else {
                            return FOUR4;
                        }
                    case 5:
                        if (accidental == '#') {
                            return SHARP_FOUR5;
                        } else {
                            return FOUR5;
                        }
                }
            case 5:
                switch(octave) {
                    case 3:
                        return FIVE3;
                    case 4:
                        return FIVE4;
                    case 5:
                        return FIVE5;
                }
            case 6:
                switch(octave) {
                    case 3:
                        if (accidental == 'b') {
                            return FLAT_SIX3;
                        } else {
                            return SIX3;
                        }
                    case 4:
                        if (accidental == 'b') {
                            return FLAT_SIX4;
                        } else {
                            return SIX4;
                        }
                    case 5:
                        if (accidental == 'b') {
                            return FLAT_SIX5;
                        } else {
                            return SIX5;
                        }
                }
            case 7:
                switch(octave) {
                    case 3:
                        if (accidental == 'b') {
                            return FLAT_SEVEN3;
                        } else {
                            return SEVEN3;
                        }
                    case 4:
                        if (accidental == 'b') {
                            return FLAT_SEVEN4;
                        } else {
                            return SEVEN4;
                        }
                    case 5:
                        if (accidental == 'b') {
                            return FLAT_SEVEN5;
                        } else {
                            return SEVEN5;
                        }
                }
        }
        return null;
    }

}
