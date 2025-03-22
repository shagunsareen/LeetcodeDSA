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
    public ListNode rotateRight(ListNode head, int k){
        if(head == null || k == 0 || head.next == null) return head;

        ListNode curr = head;
        int len = 1;
        
        //find length of the list since we need to see how many rotations are required on the list
        while(curr.next != null){
            curr = curr.next;
            len++;
        }

        //connect last node to the first node to make list circular
        curr.next = head;

        //find the rotations required on the list
        k %= len;
        curr = head; //restart the curr to start
        int newTailPos = len - k;

        for(int i=1; i<newTailPos; i++){
            curr = curr.next; 
        }

        //now curr is at the newtailpos which should point to null after making next node head
        head = curr.next;
        curr.next = null;

        return head;
    }
}