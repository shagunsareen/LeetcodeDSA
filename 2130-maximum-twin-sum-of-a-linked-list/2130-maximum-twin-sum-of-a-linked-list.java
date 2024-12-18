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
    public int pairSum(ListNode head) {
        int size = 0;
        ListNode curr = head;
        
        //Step 0 : get the size of the list
        
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        
        //Step 1 : Divide the list at n/2th node
        int halfSize = size/2;
        curr = head;
        halfSize--;
        
        while(halfSize > 0){
            curr = curr.next;
            halfSize--;
        }
        
        ListNode secHead = curr.next;
        curr.next = null;
        curr = head; //list 1
        
        //Step 2 : reverse the list 
        secHead = reverseList(secHead);  //list 2
        
        //Step 3 : compare with 2 pointers
        int maxTwinSum = Integer.MIN_VALUE;
        
        while(curr != null){
            maxTwinSum = Math.max(maxTwinSum, curr.val + secHead.val);
            curr = curr.next;
            secHead = secHead.next;
        }
        
        return maxTwinSum;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}