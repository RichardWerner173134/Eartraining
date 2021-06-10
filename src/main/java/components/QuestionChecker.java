package components;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuestionChecker {

    @Getter
    @Setter
    public static class CorrectedValue {
        Sound correctedSound;
        int countCorrect;
        int countAnswer;

        CorrectedValue(Sound correctedSound, int countCorrect, int countAnswer) {
            this.correctedSound = correctedSound;
            this.countCorrect = countCorrect;
            this.countAnswer = countAnswer;
        }
    }

    public static List<CorrectedValue> checkQuestion(List<Note> correctNotes, Answer answer){

        List<Sound> correctSounds = Note.getSoundWithoutOctave(correctNotes);
        Map<Sound, int[]> soundIntegerHashMap = new HashMap<>();

        /**
         * List with corrected Values
         * contains all correctValues, actual number, submitted number
         * contains all answerValues, which aren`t listed as correctValues, 0, submitted number
          */
        List<CorrectedValue> correctedValueList = new ArrayList<>();

        /**
         * fill the correctedValueList with the correct sounds
         * if a sound occures twice, the sound object is reused
         */
        for (Sound correctSound : correctSounds){
            if(soundIntegerHashMap.keySet()
                    .stream().noneMatch(x -> x.equals(correctSound))){
                // add new sounds to the map
                soundIntegerHashMap.put(correctSound, new int[]{1,0});
            } else {
                // add existing sounds to the reference object in the map
                Optional<Entry<Sound, int[]>> soundIntegerEntry = soundIntegerHashMap.entrySet()
                        .stream()
                        .filter(x -> x.getKey().equals(correctSound))
                        .findFirst();
                soundIntegerEntry.ifPresent(arrCorrect_Correction -> {
                    arrCorrect_Correction.getValue()[0]++;
                });
            }
        }

        /**
         *
         */
        for(Sound answerSound : answer.getSounds()){
            if (soundIntegerHashMap.keySet().stream().noneMatch(x -> x.equals(answerSound))) {
                soundIntegerHashMap.put(answerSound, new int[]{0,1});
            } else {
                Optional<Entry<Sound, int[]>> first = soundIntegerHashMap.entrySet()
                        .stream()
                        .filter(x -> x.getKey().equals(answerSound))
                        .findFirst();
                first.ifPresent(soundEntry -> {
                    soundEntry.getValue()[1]++;
                });
            }
        }

        correctedValueList.addAll(
                soundIntegerHashMap.entrySet()
                    .stream()
                    .map(soundEntry -> {
                        int[] value = soundEntry.getValue();
                        return new CorrectedValue(
                                soundEntry.getKey(),
                                value[0],
                                value[1]
                        );
                    })
                    .collect(Collectors.toList())
        );
        return correctedValueList;
    }
}
