package data_structure.java.linkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(1);

        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.append(6);
        dll.append(7);

        dll.printList();

        System.out.println("-------------");

        dll.remove(2);
        dll.printList();
        System.out.println("-------------");

        dll.insert(2, 3);
        dll.printList();



    }
}
