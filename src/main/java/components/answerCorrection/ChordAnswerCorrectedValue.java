package components.answerCorrection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.conceptOfChords.ChordType;
import model.conceptOfChords.voicing.ChordVoicing;

@Getter
@AllArgsConstructor
public class ChordAnswerCorrectedValue {
    private ChordType actualChordType;
    private ChordType submittedChordType;
    private boolean isCorrect;
    private ChordVoicing.VoicingEnum playedVoicing;
}
