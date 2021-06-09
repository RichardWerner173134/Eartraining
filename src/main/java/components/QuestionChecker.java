package components;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class QuestionChecker {

    @Getter
    public static class CorrectedValue {
        Sound answerSound;
        boolean isCorrect;

        CorrectedValue(Sound answerSound, boolean isCorrect) {
            this.answerSound = answerSound;
            this.isCorrect = isCorrect;
        }
    }

    public static List<CorrectedValue> checkQuestion(List<Note> correctNotes, Answer answer){
        List<Sound> correctSounds = Note.getSoundWithoutOctave(correctNotes);

        List<CorrectedValue> correctedValues = new ArrayList<>();

        for(Sound answerSound : answer.getSounds()){
            boolean answerSoundIsInCorrectNotes = correctSounds.stream().anyMatch(answerSound::equals);
            correctedValues.add(new CorrectedValue(answerSound, answerSoundIsInCorrectNotes));
        }



        return correctedValues;

    }
}
