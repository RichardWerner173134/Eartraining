package components.answer;

import lombok.Getter;
import lombok.Setter;
import model.conceptOfChords.Chord;
import model.oldStuff.Sound;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Answer <T> {
    protected static Answer answer;

    protected List<T> answerObjects;

    public static Answer getInstance(){
        if(answer == null){
            answer = new Answer();
        }
        return answer;
    }

    private Answer(){
        answerObjects = new ArrayList<>();
    }

    /**
     * adds an Answer to the list
     * @param answerObject
     * @return true if it adds a new answer
     * @return false if it doesnt add a new answer
     */
    public void addAnswer(T answerObject) {
        answerObjects.add(answerObject);
    }

    public void resetAnwer() {
        answerObjects = new ArrayList<>();
    }


}
