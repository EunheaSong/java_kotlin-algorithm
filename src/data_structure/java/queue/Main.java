package data_structure.java.queue;


public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(1);
        queue.printQueue();
        queue.getFirst();
        queue.getLast();
        System.out.println("--------");

        queue.enqueue(2);
        queue.printQueue();

        System.out.println("--------");
        System.out.println(queue.dequeue().value);
        System.out.println(queue.dequeue().value);
        System.out.println(queue.dequeue());

    }
}
