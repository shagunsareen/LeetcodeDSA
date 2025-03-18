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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        //move fast ahead by n+1 steps 
        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        if(fast == null){ //we have to remove head 
            return head.next;
        }

        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        //remove node 
        slow.next = slow.next.next;
        return head;
    }
}