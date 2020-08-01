package medium;

import java.util.Objects;

/**
 * 2. Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode nextListNode = null;

        int decimalNumberCount = 0;
        int nextDecimalNumberCount = 0;

        ListNode l1Next = l1;
        ListNode l2Next = l2;

        while (l1Next != null && l2Next != null) {
            if (nextListNode == null) {
                nextListNode = listNode;
            } else {
                nextListNode.next = new ListNode();
                nextListNode = nextListNode.next;
            }

            int val = l1Next.val + l2Next.val + decimalNumberCount;

            if (val >= 10) {
                nextDecimalNumberCount = 1;
                val -= 10;
            }

            nextListNode.val = val;
            decimalNumberCount = nextDecimalNumberCount;
            nextDecimalNumberCount = 0;

            l1Next = l1Next.next;
            l2Next = l2Next.next;
        }

        while (l1Next != null && l2Next == null) {
            if (nextListNode == null) {
                nextListNode = listNode;
            } else {
                nextListNode.next = new ListNode();
                nextListNode = nextListNode.next;
            }

            int val = l1Next.val + decimalNumberCount;

            if (val >= 10) {
                nextDecimalNumberCount = 1;
                val -= 10;
            }

            nextListNode.val = val;
            decimalNumberCount = nextDecimalNumberCount;
            nextDecimalNumberCount = 0;

            l1Next = l1Next.next;
        }

        while (l1Next == null && l2Next != null) {
            if (nextListNode == null) {
                nextListNode = listNode;
            } else {
                nextListNode.next = new ListNode();
                nextListNode = nextListNode.next;
            }

            int val = l2Next.val + decimalNumberCount;

            if (val >= 10) {
                nextDecimalNumberCount = 1;
                val -= 10;
            }

            nextListNode.val = val;
            decimalNumberCount = nextDecimalNumberCount;
            nextDecimalNumberCount = 0;

            l2Next = l2Next.next;
        }

        if (decimalNumberCount != 0) {
            nextListNode.next = new ListNode();
            nextListNode = nextListNode.next;
            nextListNode.val = decimalNumberCount;
        }

        return listNode;
    }

    public static class ListNode {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
