package algorithm.java.leetcode.easy;

public class MergeTwoSortedLists {
    /*
    21. Merge Two Sorted Lists
       1,2,4
       1,3,4
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            System.out.println(list1.val);
            System.out.println(list2.val);

            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            System.out.println(list1.val);
            System.out.println(list2.val);
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static class ListNode {
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
