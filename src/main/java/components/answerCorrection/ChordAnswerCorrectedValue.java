package components.answerCorrection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.conceptOfChords.ChordType;

@Getter
@AllArgsConstructor
public class ChordAnswerCorrectedValue {
    private ChordType actualChordType;
    private ChordType submittedChordType;
    private boolean isCorrect;
}
