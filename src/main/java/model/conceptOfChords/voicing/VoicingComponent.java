package model.conceptOfChords.voicing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.conceptOfIntervals.Interval;
import model.conceptOfScale.ScaleDegree;

import java.util.List;

@Getter
@AllArgsConstructor
public class VoicingComponent {
    private ScaleDegree scaleDegree;
    private List<Interval> intervalFromRoot; // a list is used for intervals bigger than an octave
}
