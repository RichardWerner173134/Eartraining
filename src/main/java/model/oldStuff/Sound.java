package model.oldStuff;

public class Sound {

    private int scaleDegree;
    private char accidental;

    public Sound(int scaleDegree, char accidental) {
        this.scaleDegree = scaleDegree;
        this.accidental = accidental;
    }

    public int getScaleDegree() {
        return this.scaleDegree;
    }

    public char getAccidental() {
        return this.accidental;
    }


    @Override
    public String toString() {
        return scaleDegreeToStringAsCMajor() + accidentalToString();
        //return scaleDegreeToString() + accidentalToString();
    }


    private String scaleDegreeToString(){
            return getScaleDegree() == 1 ? "I" :
                    getScaleDegree() == 2 ? "II" :
                            getScaleDegree() == 3 ? "III" :
                                    getScaleDegree() == 4 ? "IV" :
                                            getScaleDegree() == 5 ? "V" :
                                                    getScaleDegree() == 6 ? "VI" : "VII";
    }

    private String scaleDegreeToStringAsCMajor(){
        return getScaleDegree() == 1 ? "C" :
                getScaleDegree() == 2 ? "D" :
                        getScaleDegree() == 3 ? "E" :
                                getScaleDegree() == 4 ? "F" :
                                        getScaleDegree() == 5 ? "G" :
                                                getScaleDegree() == 6 ? "A" : "B";
    }

    private String accidentalToString(){
        return getAccidental() == 'n' ? "" :
                getAccidental() == 'b' ? "b" : "#";
    }

    @Override
    public boolean equals(Object obj) {
        return scaleDegree == ((Sound)obj).getScaleDegree() && accidental == ((Sound)obj).getAccidental();
    }
}