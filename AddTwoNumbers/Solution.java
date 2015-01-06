import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {

        ListNode newHead = null;
        ListNode prev = null;
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        int carry = 0;

        while (l1Current != null && l2Current != null) {
            final int sum = l1Current.val + l2Current.val + carry;
            final int digit = sum % 10;
            carry = sum / 10;
            final ListNode node = new ListNode(digit);
            if (prev == null) {
                newHead = node;
            } else {
                prev.next = node;
            }
            prev = node;
            l1Current = l1Current.next;
            l2Current = l2Current.next;
        }


        ListNode leftOver = null;
        // There can be at most one null for l1Current and l2Current
        if (l1Current != null) {
            leftOver = l1Current;
        } else if (l2Current != null) {
            leftOver = l2Current;
        }
        
        while (leftOver != null) {
            final int sum = leftOver.val + carry;
            final ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            if (prev == null) {
                newHead = node;
            } else {
                prev.next = node;
            }
            prev = node;
            leftOver = leftOver.next;
        }

        // Please, DO NOT forget this!
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        
        return newHead;
    }
}

