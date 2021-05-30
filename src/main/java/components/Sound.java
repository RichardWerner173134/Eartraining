package components;

import java.util.HashMap;

public enum Sound {

    ONE(1),
    FLAT_TWO(2, 'b'),
    TWO(2),
    FLAT_THREE(3, 'b'),
    THREE(3),
    FOUR(4),
    SHARP_FOUR(4, '#'),
    FIVE(5),
    FLAT_SIX(6, 'b'),
    SIX(6),
    FLAT_SEVEN(7, 'b'),
    SEVEN(7);

    private int scaleDegree;
    private char accidental;

    Sound(int scaleDegree){
        this.scaleDegree = scaleDegree;
        this.accidental = 'n';
    }

    Sound(int scaleDegree, char accidental){
        this.scaleDegree = scaleDegree;
        this.accidental = accidental;
    }

    public int getScaleDegree(){
        return this.scaleDegree;
    }

    public char getAccidental(){
        return this.accidental;
    }

    public String getSoundString() throws Exception {
        HashMap<Integer, Character> cMajorMap = new HashMap<>();
        cMajorMap.put(Sound.ONE.scaleDegree, 'C');
        cMajorMap.put(Sound.TWO.scaleDegree, 'D');
        cMajorMap.put(Sound.THREE.scaleDegree, 'E');
        cMajorMap.put(Sound.FOUR.scaleDegree, 'F');
        cMajorMap.put(Sound.FIVE.scaleDegree, 'G');
        cMajorMap.put(Sound.SIX.scaleDegree, 'A');
        cMajorMap.put(Sound.SEVEN.scaleDegree, 'B');

        String note = cMajorMap.get(scaleDegree).toString();

        if(accidental == 'n'){
            return note;
        } else if(accidental == 'b' || accidental == '#'){
            return note + accidental;
        }
        throw new Exception("Unknown accidental");
    }

    public static Sound getSoundType(int scaleDegree, char accidental){
        switch(scaleDegree){
            case 1:
                return ONE;
            case 2:
                if(accidental == 'b'){
                    return FLAT_TWO;
                }
                return TWO;
            case 3:
                if(accidental == 'b'){
                    return FLAT_THREE;
                }
                return THREE;
            case 4:
                if(accidental == '#'){
                    return SHARP_FOUR;
                }
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                if(accidental == 'b'){
                    return FLAT_SIX;
                }
                return SIX;
            case 7:
                if(accidental == 'b'){
                    return FLAT_SEVEN;
                }
                return SEVEN;
        }
        return null;
    }

}
