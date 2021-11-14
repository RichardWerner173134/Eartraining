package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;

@Getter
@Setter
@AllArgsConstructor
public class CircularLinkedListNode<T> implements Iterable{
    private T value;
    private CircularLinkedListNode next;
    private CircularLinkedListNode previous;

    @Override
    public Iterator iterator() {
        CircleOfFifths instance = CircleOfFifths.getInstance();
        instance.resetIterator();
        return instance;
    }
}
