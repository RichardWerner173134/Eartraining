package components;


public class Config {
    private static Config config;

    private NumberOfNotes numberOfNotes;
    private ScaleDegreeMix scaleDegreeMix;

    private Config(){
        numberOfNotes = NumberOfNotes.THREE;
        scaleDegreeMix = ScaleDegreeMix.ONE_FOUR_FIVE;
    }

    public static Config getInstance(){
        if(config == null){
            config = new Config();
        }
        return config;
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

    public int getIntNumberOfNotes(){
        return this.numberOfNotes.getNumberOfNotes();
    }

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

        public int getNumberOfNotes(){
            return numberOfNotes;
        }
    }

    public enum ScaleDegreeMix{
        ONE_FOUR_FIVE(),
        ALL_DIATONIC(),
        ALL_DIATONIC_AND_ACCIDENTALS();
    }
}
