package components;

import lombok.Getter;
import lombok.Setter;
import model.Sound;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Answer {
    private static Answer answer;

    private List<Sound> sounds;

    private Answer(){
        sounds = new ArrayList<>();
    }

    public static Answer getInstance(){
        if(answer == null){
            answer = new Answer();
        }
        return answer;
    }

    public static void resetAnswer(){
        answer.setSounds(new ArrayList<>());
    }

    /**
     * adds an Answer to the list
     * @param sound
     * @return true if it adds a new answer
     * @return false if it doesnt add a new answer
     */
    public boolean addAnswer(Sound sound){
        sounds.add(sound);
        return true;
    }

}
