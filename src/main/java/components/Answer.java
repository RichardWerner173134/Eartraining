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

    public void addAnswer(Sound sound){
        sounds.add(sound);
    }
}
