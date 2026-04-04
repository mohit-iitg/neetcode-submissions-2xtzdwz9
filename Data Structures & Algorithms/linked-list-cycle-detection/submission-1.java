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
        ListNode tor = head, hare = head;
        while(hare != null && hare.next != null) {
            tor = tor.next;
            hare = hare.next.next;
            if(tor == hare) {
                return true;
            }
        }
        return false;
    }
}
