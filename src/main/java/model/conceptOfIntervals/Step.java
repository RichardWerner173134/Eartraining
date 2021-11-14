package model.conceptOfIntervals;

import lombok.Getter;

@Getter
public enum Step {
    WHOLE_STEP(2),
    HALF_STEP(1);

    private int number;

    private Step(int number){
        this.number = number;
    }
}
