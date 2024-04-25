package data_structure.java.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(2);
        stack.printStack();
        System.out.println("----------");

        stack.push(3);
        stack.printStack();
        System.out.println("----------");

        Stack.Node node = stack.pop();
        System.out.println(node.value);
        System.out.println("\n");
        stack.pop();
        stack.push(1);
        stack.printStack();

    }
}
