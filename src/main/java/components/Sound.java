package components;

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


}