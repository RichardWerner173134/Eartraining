package components;

import lombok.Getter;
import lombok.Setter;

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
        answer = null;
    }

    /**
     * adds an Answer to the list
     * @param sound
     * @return true if it adds a new answer
     * @return false if it doesnt add a new answer
     */
    public boolean addAnswer(Sound sound){
        boolean isPresent = false;
        for(Sound s : sounds){
            if(s.getAccidental() == sound.getAccidental() && s.getScaleDegree() == sound.getScaleDegree()){
                isPresent = true;
            }
        }

        if(!isPresent){
            sounds.add(sound);
            return true;
        }
        return false;
    }

}
