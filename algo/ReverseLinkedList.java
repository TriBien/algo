// Ref: https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {
            cur.next = newHead;
            newHead = cur;
            cur = next;
            next = cur.next;
        }

        cur.next = newHead;
        newHead = cur;
        
        return newHead;
    }
}