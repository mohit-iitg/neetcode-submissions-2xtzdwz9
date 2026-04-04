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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode tor = head, hare = head;
        while(true) {
            tor = tor.next;
            if(hare != null && hare.next != null) {
                hare = hare.next.next;
            } else {
                return false;
            }

            if(tor == hare) {
                break;
            }
        }
        return true;
    }
}
