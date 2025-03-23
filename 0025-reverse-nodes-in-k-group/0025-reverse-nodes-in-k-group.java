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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode newHead = null;
        ListNode prevTail = null;
        ListNode newTail = null;

        //reverse logic
        ListNode curr = head;

        while(curr != null){
            
            //PREREQUISITE STEP - check if there are k nodes or not
            int count = 0;
            ListNode temp = curr;
            while(temp != null){
                temp = temp.next;
                count++;
            }

            if(count < k){
                if(prevTail != null){
                    prevTail.next = curr;
                }
                break;
            }
            
            //REVERSE NODES LOGIC
            ListNode prev = null;
            ListNode next = null;

            //before picking any k group list just keep start element as newTail since it would be required to attach later reversed lists to the tail
            newTail = curr;

            //we need to reverse k nodes at a time 
            for(int i=0; i<k; i++){
                next = curr.next; 
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if(newHead == null){
                newHead = prev;
            }else{
                prevTail.next = prev;
            }

            prevTail = newTail;
        }  
        return newHead;
    }
}