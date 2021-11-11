package model.conceptOfNote;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Getter
public enum NoteLetter {
    C("C", 0),
    D("D", 2),
    E("E", 4),
    F("F", 5),
    G("G", 7),
    A("A", 9),
    B("B", 11);

    private String letter;
    private int pos;

    private NoteLetter(String letter, int pos){
        this.letter = letter;
        this.pos = pos;
    }

    public static List<NoteLetter> getOrderedNoteLetters(){
        return Arrays.asList(C, D, E, F, G, A, B);
    }

    public static List<NoteLetter> getOrderedNoteLettersBeginningFromNoteLetter(NoteLetter letter){
        List<NoteLetter> list = new ArrayList<>();
        List<NoteLetter> listSkipped = new ArrayList<>();
        Iterator<NoteLetter> iterator = getOrderedNoteLetters().iterator();
        while(iterator.hasNext()){
            NoteLetter next = iterator.next();
            if(letter == next){
                list.add(next);
                while(iterator.hasNext()){
                    next = iterator.next();
                    list.add(next);
                }
            } else{
                listSkipped.add(next);
            }
        }

        list.addAll(listSkipped);
        return list;
    }
}
