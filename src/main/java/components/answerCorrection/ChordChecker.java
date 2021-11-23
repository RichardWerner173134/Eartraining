package components.answerCorrection;

import components.answer.Answer;
import model.conceptOfChords.Chord;
import model.conceptOfChords.ChordType;
import model.conceptOfChords.voicing.ChordVoicing;

import java.util.List;

public class ChordChecker {
    public static ChordAnswerCorrectedValue checkQuestion(ChordType expectedChordType, ChordVoicing.VoicingEnum playedVoicing, Answer<ChordType> answer) throws Exception {
        List<ChordType> answerObjects = answer.getAnswerObjects();
        if(answerObjects == null){
            throw new Exception("Answer empty");
        }
        if(answerObjects.size() != 1){
            throw new Exception("Answer can only contain 1 value");
        }

        ChordType submittedChordType = answer.getAnswerObjects().get(0);

        boolean isCorrect = expectedChordType == submittedChordType;
        return new ChordAnswerCorrectedValue(expectedChordType, submittedChordType, isCorrect, playedVoicing);
    }
}
