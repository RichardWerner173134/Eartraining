package components.notepicker;

import components.Config;
import model.oldStuff.Note;
import components.SoundManager;

import java.util.Random;

public class ChromaticNotePicker implements INotePicker {
    private int[] scaleDegrees;
    private int[] octaveDescription;
    private Random rand;

    public ChromaticNotePicker() {
        scaleDegrees = new int[]{1, 3, 4, 5, 6, 7};
        octaveDescription = Config.getInstance().getOctaveNumberIntervall();
        rand = new Random();
    }

    @Override
    public Note pickNote() {
        Note newRandomNote = null;

        // picking a random scaleDegree of 1, 3, 4, 5
        int pickedScaleDegree = scaleDegrees[rand.nextInt(scaleDegrees.length)];

        // pick an accidental or not
        int pickedAccidental = rand.nextInt(2);

        // pick an octave
        int pickedOctave = octaveDescription[rand.nextInt(octaveDescription.length)];

        try {
            newRandomNote = SoundManager.getNote(pickedScaleDegree, pickedAccidental, pickedOctave);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newRandomNote;
    }
}
