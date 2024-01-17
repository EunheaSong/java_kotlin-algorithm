package algorithm.java.leetcode.easy;

import java.util.*;

public class PalindromeLinkedList {
    /*
    234. Palindrome Linked List


     */

    public boolean isPalindrome(ListNode head) {
        StringBuilder s = new StringBuilder();
        ListNode h = head;
        while (h != null) {
            s.append(h.val);
            h = h.next;
        }
        String originalString = s.toString();
        String reverseString = s.reverse().toString();
        return originalString.equals(reverseString);
    }

    public static class BookAnswer {

        //스택을 활용한 풀이
        public boolean isPalindromeUsedStack(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode node = head;
            while (node != null) {
                stack.add(node.val);
                node = node.next;
            }

            while (head != null) {
                if (head.val != stack.pop()) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }

        //데크를 활용한 풀이
        public boolean isPalindromeUsedDeque(ListNode head) {
            Deque<Integer> deque = new LinkedList<>();
            ListNode node = head;
            while (node != null) {
                deque.add(node.val);
                node = node.next;
            }
            while (!deque.isEmpty() && deque.size() > 1) {
                if (deque.pollFirst() != deque.pollLast()) {
                    return false;
                }
            }
            return true;
        }

        //러너를 활용한 풀이
        public boolean isPalindromeUsedRunner(ListNode head) {
            //빠른 러너, 느린 러너.
            ListNode fast = head, slow = head;
            //빠른 러너는 두 칸씩 이동. 느린 러너는 한 칸씩 이동.
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            //홀수인 경우에는 느린 러너를 한 칸 더 이동시킨다.
            if (fast != null) {
                slow = slow.next;
            }

            //중간에 도달한 느린 러너를 기준으로 하여 역순 연결 리스트를 만든다.
            ListNode rev = null;
            while (slow != null) {
                ListNode next = slow.next;
                slow.next = rev;
                rev = slow;
                slow = next;
            }

            //rev 연결 리스트를 끝까지 이동하며 비교
            while (rev != null) {
                //역순 연결리스트 rev 와 기존 연결 리스트 head 를 차례대로 비교
                if (rev.val != head.val) {
                    return false;
                }
                rev = rev.next;
                head = head.next;
            }
            return true;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
