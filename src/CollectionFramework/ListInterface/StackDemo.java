package CollectionFramework.ListInterface;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // 1. push (LIFO insertion)
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack after pushes: " + stack); // [A, B, C]

        // 2. peek (top without removal)
        System.out.println("peek(): " + stack.peek()); // C

        // 3. pop (remove and return top)
        System.out.println("pop(): " + stack.pop());   // C
        System.out.println("Stack after pop: " + stack); // [A, B]

        // 4. empty()
        System.out.println("empty(): " + stack.empty()); // false

        // 5. search() — returns 1-based position from top
        stack.push("D"); // stack: [A, B, D]
        System.out.println("Stack: " + stack);

        System.out.println("search(\"D\"): " + stack.search("D")); // 1
        System.out.println("search(\"A\"): " + stack.search("A")); // 3
        System.out.println("search(\"X\"): " + stack.search("X")); // -1 (not found)
    }
}

