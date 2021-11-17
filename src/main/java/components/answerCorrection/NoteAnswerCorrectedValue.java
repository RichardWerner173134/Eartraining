package components.answerCorrection;

import lombok.Getter;
import lombok.Setter;
import model.oldStuff.Sound;

@Getter
@Setter
public class NoteAnswerCorrectedValue {
    Sound correctedSound;
    int countCorrect;
    int countAnswer;

    NoteAnswerCorrectedValue(Sound correctedSound, int countCorrect, int countAnswer) {
        this.correctedSound = correctedSound;
        this.countCorrect = countCorrect;
        this.countAnswer = countAnswer;
    }
}