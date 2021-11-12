package components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CircularLinkedListNode<T>{
    private T value;
    private CircularLinkedListNode next;
    private CircularLinkedListNode previous;
}
