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
    public ListNode partition(ListNode head, int x){
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);

        ListNode firstPtr = first;
        ListNode secondPtr = second;

        while(head != null){
            if(head.val < x){
                firstPtr.next = head;
                firstPtr = firstPtr.next;
            }else{
                secondPtr.next = head;
                secondPtr = secondPtr.next;
            }
            head = head.next;
        }

        secondPtr.next = null;
        firstPtr.next = second.next;
        
        return first.next; 
    }
}