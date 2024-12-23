// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.
// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
//
// Example 2:
// Input: lists = []
// Output: []
//
// Example 3:
// Input: lists = [[]]
// Output: []
//
// Constraints:
// k == lists.length
// 0 <= k <= 104
// 0 <= lists[i].length <= 500
// -104 <= lists[i][j] <= 104
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 104.

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
// Time Complexity: O(nlogk)
// Space Complexity: O(logk)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        return mergeDivideAndConquer(lists, 0, lists.length - 1);
    }

    private ListNode mergeDivideAndConquer(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode leftBranch = mergeDivideAndConquer(lists, left, mid);
        ListNode rightBranch = mergeDivideAndConquer(lists, mid + 1, right);

        return mergeTwoLists(leftBranch, rightBranch);
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                current = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                current = head2;
                head2 = head2.next;
            }
        }

        if (head1 == null) {
            current.next = head2;
        } else {
            current.next = head1;
        }

        return head.next;
    }
}
