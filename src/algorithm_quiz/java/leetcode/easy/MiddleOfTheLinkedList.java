package algorithm_quiz.java.leetcode.easy;

public class MiddleOfTheLinkedList {
    /*
        876. Middle of the Linked List
     */

    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode nowNode = head;
        ListNode middleNode = head;
        while (nowNode.next != null) {
            count++;
            if (count % 2 == 0) middleNode = middleNode.next;
            nowNode = nowNode.next;
        }
        return middleNode;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
