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
    public ListNode doubleIt(ListNode head) {
        
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        
        //inserted all nodes in stack, since we want sum so we needed last element first and now we can access last element first when we pop stack top
        int carry = 0;
        ListNode reverseHead = null;
        while(!stack.isEmpty()){
               ListNode peekNode = stack.pop();
               int multipliedVal =  carry + 2*peekNode.val;
               carry = multipliedVal/10; //1
               peekNode.val = multipliedVal%10; //8
               peekNode.next = reverseHead; 
               reverseHead = peekNode;
        }
        
        if(carry!=0){
            ListNode carryNode = new ListNode(carry);
            carryNode.next = reverseHead;
            reverseHead = carryNode;
        }
        
        return reverseHead;
    }
}