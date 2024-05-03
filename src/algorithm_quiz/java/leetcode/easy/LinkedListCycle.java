package algorithm_quiz.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    /*
    141. Linked List Cycle
     */

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> m = new HashMap();
        if (head == null) return false;
        return cycle(head, m);

    }

    public boolean cycle(ListNode head, Map<ListNode, Integer> m) {
        if (head.next != null) {
            if (m.containsKey(head.next)) {
                return true;
            }
            m.put(head.next, head.val);
            return cycle(head.next, m);
        } else {
            return false;
        }
    }

    static class LeetCodeAnswer {

        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
