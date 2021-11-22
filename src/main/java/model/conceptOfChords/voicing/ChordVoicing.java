package model.conceptOfChords.voicing;

import lombok.Getter;
import model.conceptOfChords.ChordType;

import java.util.Arrays;
import java.util.List;

import static model.conceptOfChords.voicing.ChordVoicing.VoicingEnum.*;
import static model.conceptOfIntervals.Interval.*;
import static model.conceptOfScale.ScaleDegree.*;

@Getter
public class ChordVoicing {

    private List<VoicingComponent> voicingComponents;

    public ChordVoicing(List<VoicingComponent> voicingComponents){
        this.voicingComponents = voicingComponents;
    }

    public static List<VoicingEnum> getVoicingsForChordType(ChordType chordType) throws Exception {
        switch(chordType){
            case MAJOR:
                return Arrays.asList(
                        MAJOR_TRIAD_BASIC,
                        MAJOR_TRIAD_FIRST_INVERSION,
                        MAJOR_TRIAD_SECOND_INVERSION,
                        MAJOR_TRIAD_OPEN
                );
            case MINOR:
                return Arrays.asList(
                        MINOR_TRIAD_BASIC,
                        MINOR_TRIAD_FIRST_INVERSION,
                        MINOR_TRIAD_SECOND_INVERSION,
                        MINOR_TRIAD_OPEN
                );
            case DIMINISHED:
                return Arrays.asList(
                        DIMINISHED_BASIC
                );
            case AUGMENTED:
                return Arrays.asList(
                        AUGMENTED_BASIC
                );
            case MAJOR_SEVENTH:
                return Arrays.asList(
                        MAJOR_SEVENTH_BASIC,
                        MAJOR_SEVENTH_SHELL,
                        MAJOR_SEVENTH_SHELL_OPEN,
                        MAJOR_SEVENTH_CLOSED
                );
            case MINOR_SEVENTH:
                return Arrays.asList(
                        MINOR_SEVENTH_BASIC,
                        MINOR_SEVENTH_SHELL,
                        MINOR_SEVENTH_SHELL_OPEN,
                        MINOR_SEVENTH_CLOSED
                );
            case DOMINANT_SEVENTH:
                return Arrays.asList(
                        DOMINANT_SEVENTH_BASIC
                );
            case HALF_DIMINISHED_SEVENTH:
                return Arrays.asList(
                        HALF_DIMINISHED_SEVENTH_BASIC
                );
            case FULLY_DIMINISHED_SEVEN:
                return Arrays.asList(
                        FULLY_DIMINISHED_SEVENTH_BASIC
                );
            case MINOR_MAJOR_SEVENTH:
                return Arrays.asList(
                        MINOR_MAJOR_SEVENTH_BASIC
                );
        }
        throw new Exception("alsdjhajh");
    }

    @Getter
    public enum VoicingEnum {
        // MAJOR TRIADS
        MAJOR_TRIAD_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MAJOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH))
                )
        ),

        MAJOR_TRIAD_FIRST_INVERSION(
                Arrays.asList(
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MAJOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_OCTAVE))
                )
        ),

        MAJOR_TRIAD_SECOND_INVERSION(
                Arrays.asList(
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_OCTAVE)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MAJOR_THIRD))
                )
        ),

        MAJOR_TRIAD_OPEN(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(PERFECT_OCTAVE, MAJOR_THIRD)) // THIRD ONE OCTAVE HIGHER
                )
        ),

        // MINOR TRIAD VOICINGS
        MINOR_TRIAD_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH))
                )
        ),

        MINOR_TRIAD_FIRST_INVERSION(
                Arrays.asList(
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_OCTAVE))
                )
        ),

        MINOR_TRIAD_SECOND_INVERSION(
                Arrays.asList(
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_OCTAVE)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD))
                )
        ),

        MINOR_TRIAD_OPEN(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(PERFECT_OCTAVE, MINOR_THIRD))
                )
        ),

        // DIMINISHED
        DIMINISHED_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FLAT_FIFTH, Arrays.asList(DIMINISHED_FIFTH))
                )
        ),

        // AUGMENTED
        AUGMENTED_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MAJOR_THIRD)),
                        new VoicingComponent(SHARP_FIFTH, Arrays.asList(MINOR_SIXTH))
                )
        ),

        // MAJOR SEVENTHS VOICINGS
        MAJOR_SEVENTH_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MAJOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(NATURAL_SEVENTH, Arrays.asList(MAJOR_SEVENTH))
                )
        ),

        MAJOR_SEVENTH_SHELL(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MAJOR_THIRD)),
                        new VoicingComponent(NATURAL_SEVENTH, Arrays.asList(MAJOR_SEVENTH))
                )
        ),

        MAJOR_SEVENTH_SHELL_OPEN(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_SEVENTH, Arrays.asList(MAJOR_SEVENTH)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(PERFECT_OCTAVE, MAJOR_THIRD))
                )
        ),
        MAJOR_SEVENTH_CLOSED(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_OCTAVE, PERFECT_FIFTH)),
                        new VoicingComponent(NATURAL_SEVENTH, Arrays.asList(PERFECT_OCTAVE, MAJOR_SEVENTH)),
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_OCTAVE, PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(PERFECT_OCTAVE, PERFECT_OCTAVE, MAJOR_THIRD))
                )
        ),

        // MINOR SEVENTHS VOICINGS
        MINOR_SEVENTH_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(FLAT_SEVENTH, Arrays.asList(MINOR_SEVENTH))
                )
        ),

        MINOR_SEVENTH_SHELL(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FLAT_SEVENTH, Arrays.asList(MINOR_SEVENTH))
                )
        ),

        MINOR_SEVENTH_SHELL_OPEN(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_SEVENTH, Arrays.asList(MINOR_SEVENTH)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(PERFECT_OCTAVE, MINOR_THIRD))
                )
        ),

        MINOR_SEVENTH_CLOSED(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_OCTAVE, PERFECT_FIFTH)),
                        new VoicingComponent(FLAT_SEVENTH, Arrays.asList(PERFECT_OCTAVE, MINOR_SEVENTH)),
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_OCTAVE, PERFECT_OCTAVE)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(PERFECT_OCTAVE, PERFECT_OCTAVE, MINOR_THIRD))
                )
        ),

        // MAJOR NINTH VOICINGS
        MAJOR_NINTH_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MAJOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(NATURAL_SEVENTH, Arrays.asList(MAJOR_SEVENTH)),
                        new VoicingComponent(NATURAL_SECOND, Arrays.asList(PERFECT_OCTAVE, MAJOR_SECOND))
                )
        ),

        MAJOR_NINTH_CLOSE(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_SEVENTH, Arrays.asList(MAJOR_SEVENTH)),
                        new VoicingComponent(NATURAL_SECOND, Arrays.asList(PERFECT_OCTAVE, MAJOR_SECOND)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(PERFECT_OCTAVE, MAJOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_OCTAVE, PERFECT_FIFTH))
                )
        ),

        // MAJOR NINTH VOICINGS
        MINOR_NINTH_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(FLAT_SEVENTH, Arrays.asList(MINOR_SEVENTH)),
                        new VoicingComponent(NATURAL_SECOND, Arrays.asList(PERFECT_OCTAVE, MAJOR_SECOND))
                )
        ),

        MINOR_NINTH_CLOSE(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_SEVENTH, Arrays.asList(MINOR_SEVENTH)),
                        new VoicingComponent(NATURAL_SECOND, Arrays.asList(PERFECT_OCTAVE, MAJOR_SECOND)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(PERFECT_OCTAVE, MINOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_OCTAVE, PERFECT_FIFTH))
                )
        ),

        // DOMINANT SEVENTHS
        DOMINANT_SEVENTH_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MAJOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(FLAT_SEVENTH, Arrays.asList(MINOR_SEVENTH))
                )
        ),

        // HALF DIMINISHED SEVENTH
        HALF_DIMINISHED_SEVENTH_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FLAT_FIFTH, Arrays.asList(DIMINISHED_FIFTH)),
                        new VoicingComponent(FLAT_SEVENTH, Arrays.asList(MINOR_SEVENTH))
                )
        ),

        // HALF DIMINISHED SEVENTH
        FULLY_DIMINISHED_SEVENTH_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(FLAT_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FLAT_FIFTH, Arrays.asList(DIMINISHED_FIFTH)),
                        new VoicingComponent(DOUBLE_DIMINISHED_SEVENTH, Arrays.asList(MAJOR_SIXTH))
                )
        ),

        MINOR_MAJOR_SEVENTH_BASIC(
                Arrays.asList(
                        new VoicingComponent(ROOT, Arrays.asList(PERFECT_UNISON)),
                        new VoicingComponent(NATURAL_THIRD, Arrays.asList(MINOR_THIRD)),
                        new VoicingComponent(FIFTH, Arrays.asList(PERFECT_FIFTH)),
                        new VoicingComponent(NATURAL_SEVENTH, Arrays.asList(MAJOR_SEVENTH))
                )
        )
        ;

        private ChordVoicing voicing;

        private VoicingEnum (List<VoicingComponent> voicingComponents){
            this.voicing = new ChordVoicing(voicingComponents);
        }
    }
}



