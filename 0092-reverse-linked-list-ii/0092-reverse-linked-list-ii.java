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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        //Step 1 : Traverse with pointer till left-1 node so that we have pointer to connect reversed list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevLeft = dummy;

        int i=1;
        while(i < left && prevLeft != null){
            prevLeft = prevLeft.next;
            i++;
        }

        ListNode startR = prevLeft.next; //start of reversed list
        ListNode currR = startR;
        ListNode prevR = null;
        ListNode nextR = null;

        for(int j=left; j<=right; j++){
            nextR = currR.next;
            currR.next = prevR;
            prevR = currR;
            currR = nextR;
        }

        //prevR will be the head of reversedList
        //currR would be at C+1 th node 
        //startR would be the end of reversedList

        //now attach head of reversedList and tail of reversedList
        prevLeft.next = prevR; //attaching reversed list's head 
        startR.next = currR;

        return dummy.next;
    }
}