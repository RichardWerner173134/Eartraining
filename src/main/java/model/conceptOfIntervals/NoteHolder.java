package model.conceptOfIntervals;

import lombok.Getter;
import lombok.Setter;
import model.CircleOfFifths;
import model.conceptOfNote.Note;

@Setter
@Getter
public class NoteHolder {
    private Note clockwise;
    private Note counterClockwise;

    public NoteHolder(Note note, CircleOfFifths.Direction direction) {
        if (direction == CircleOfFifths.Direction.UP){
            clockwise = note;
        } else {
            counterClockwise  = note;
        }
    }

    public Note getNote(CircleOfFifths.Direction direction){
        if (direction == CircleOfFifths.Direction.UP){
            return clockwise != null ? clockwise : counterClockwise;
        } else {
            return counterClockwise != null ? counterClockwise : clockwise;
        }
    }

    public void setNote(Note note, CircleOfFifths.Direction direction){
        if (direction == CircleOfFifths.Direction.UP){
            clockwise = note;
        } else {
            counterClockwise  = note;
        }
    }

    @Override
    public String toString() {
        String s = "";
        if(clockwise != null){
            s += clockwise.toString();
        }

        if(counterClockwise != null){
            if(s.length() > 0){
                s += "/" + counterClockwise.toString();
            } else {
                s += counterClockwise.toString();
            }
        }

        return s;
    }
}
