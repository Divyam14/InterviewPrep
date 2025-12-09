package CollectionFramework.QueueInterface;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Stack using ArrayDeque: " + stack);

        System.out.println("pop(): " + stack.pop());   // C
        System.out.println("peek(): " + stack.peek()); // B
        System.out.println("After pop: " + stack);
    }
}

