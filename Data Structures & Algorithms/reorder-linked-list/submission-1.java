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
    public void reorderList(ListNode head) {
        if(head == null) return;

        // find half of the list
        ListNode slow = head, fast = head;
        // at the end of this loop, the slow would be the end
        // of the first list. use second list then
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow.next;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        slow.next = null;

        // join the two lists in required order
        ListNode ptr1 = head, ptr2 = prev;
        while(ptr1 != null) {
            ListNode ptr1Next = ptr1.next;
            ListNode ptr2Next = (ptr2 == null) ? null : ptr2.next;

            ptr1.next = ptr2;
            ptr1 = ptr1.next;
            if(ptr1 != null) {
                ptr1.next = ptr1Next;
                ptr1 = ptr1.next;
            }

            ptr2 = ptr2Next;
        }
    }
}
