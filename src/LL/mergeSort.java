package LL;

public class mergeSort {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = findmid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(rightHead);

        return mergeList(leftSorted, rightSorted);
    }

    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left != null) temp.next = left;
        if (right != null) temp.next = right;

        return dummy.next;
    }

    public ListNode findmid(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
