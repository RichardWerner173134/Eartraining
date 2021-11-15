package model.conceptOfChords;

import lombok.Getter;
import model.conceptOfScale.ScaleDegree;

import java.util.Arrays;
import java.util.List;

@Getter
public enum ChordType {

    MAJOR(Arrays.asList(ScaleDegree.ROOT, ScaleDegree.THIRD, ScaleDegree.FIFTH)),
    MINOR(Arrays.asList(ScaleDegree.ROOT, ScaleDegree.FLAT_THIRD, ScaleDegree.FIFTH)),
    MAJOR_SEVENTH(Arrays.asList(ScaleDegree.ROOT, ScaleDegree.THIRD, ScaleDegree.FIFTH, ScaleDegree.SEVENTH)),
    MINOR_SEVENTH(Arrays.asList(ScaleDegree.ROOT, ScaleDegree.FLAT_THIRD, ScaleDegree.FIFTH, ScaleDegree.FLAT_SEVENTH)),
    DOMINANT_SEVENTH(Arrays.asList(ScaleDegree.ROOT, ScaleDegree.THIRD, ScaleDegree.FIFTH, ScaleDegree.FLAT_SEVENTH));

    private Tonality tonality;
    private List<ScaleDegree> scaleDegrees;

    private ChordType(List<ScaleDegree> scaleDegrees) {
        this.scaleDegrees = scaleDegrees;
        try {
            this.tonality = calculateTonality(scaleDegrees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Tonality calculateTonality(List<ScaleDegree> scaleDegrees) throws Exception {
        if(scaleDegrees.contains(ScaleDegree.THIRD) && scaleDegrees.contains(ScaleDegree.FIFTH)){
            return Tonality.MAJOR;
        }
        if(scaleDegrees.contains(ScaleDegree.FLAT_THIRD) && scaleDegrees.contains(ScaleDegree.FIFTH)){
            return Tonality.MINOR;
        }
        throw new Exception("Cant calculate Tonality");
    }
}
