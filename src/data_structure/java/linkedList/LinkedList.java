package data_structure.java.linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if(length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp; //이게 tail node 의 직전 node 가 될 것.
            temp = pre.next; //이게 tail node 가 될 것.
        }
        tail = pre; //tail 을 기존 tail node 의 직전 node 로 변경.
        tail.next = null; //기존 tail node 를 제거.
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    //가장 앞 쪽에 삽입
    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0) return null;
        Node temp = head;
        head = head.next; //기존 head 의 직후 node 를 head 로 만든다.
        temp.next = null;
        length--;
        if (length == 0) { //애초에 node 가 하나였을 때.
            tail = null;
        }
        return temp; //삭제된 node를 리턴.
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index >= length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index -1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) removeFirst();
        if (index == length-1) removeLast();
        Node prev = get(index -1);
        Node temp = get(index);
        prev.next = temp.next;
        length--;
        return temp;
    }

    public void reverse() {
        //head 와 tail 을 교체.
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = null;
        Node before = null;
        //1,2,3,4 // 4,3,2,1
        for (int i = 0; i < length; i++) {
            after = temp.next; // 2 3 4
            temp.next = before; // null 1 2
            before = temp; // 1 2 3
            temp = after; // 2 3 4
        }
    }

    public void getHead() {
        System.out.println("Head : " + head.value);
    }

    public void getTail() {
        System.out.println("Tail : " + tail.value);
    }

    public void getLength() {
        System.out.println("Length : " + length);
    }


    // LinkedList Test //

    /*
    Implement a method called findMiddleNode that returns the middle node of the linked list.
    If the list has an even number of nodes, the method should return the second middle node.
    Note: this LinkedList implementation does not have a length member variable.
     */
    public Node findMiddleNode() {
        if(head == null) return null;
        if(head == tail) return head;
        Node slow = head;
        Node fast = head;
        Node middleNode;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast =  fast.next.next;
        }
        return slow;
    }

    /*
    Write a method called hasLoop that is part of the linked list class.
    The method should be able to detect if there is a cycle or loop present in the linked list.
    You are required to use Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.
    This algorithm uses two pointers: a slow pointer and a fast pointer.
        The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
        If there is a loop in the linked list, the two pointers will eventually meet at some point.
        If there is no loop, the fast pointer will reach the end of the list.
    Note: In this problem, you should use the slow and fast pointer technique
        (also known as Floyd's Tortoise and Hare algorithm) to efficiently detect the presence of a loop in the linked list
     */
    public boolean hasLoop() {
        if(length < 2) return false;

        Node slow = head;
        Node fast = head.next.next;

        while( fast != null && fast.next != null) {
            if(fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /*
    Implement a method called findKthFromEnd that returns the k-th node from the end of the list.
    If the list has fewer than k nodes, the method should return null.

    Note: This implementation of the Linked List class does not have the length attribute.
     */
    public Node findKthFromEnd(int k) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        int i = 0;
        while (i < k && fast != null) {
            if(i == k) i = 0;
            fast = fast.next;
            slow = slow.next;
            i++;
        }
        return slow;
    }
}
