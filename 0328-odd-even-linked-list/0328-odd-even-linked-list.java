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
    public ListNode oddEvenList(ListNode head) {
       if(head != null){
           ListNode odd = head;
           ListNode even = head.next;
           ListNode evenH = even;
           
           while(even != null && even.next != null){
               odd.next = odd.next.next;
               even.next = even.next.next;
               odd = odd.next;
               even = even.next;
           }
           
           //connect odd list to even list 
           odd.next = evenH;
       } 
       return head;
    }
}