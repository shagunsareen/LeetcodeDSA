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
    public ListNode removeNodes(ListNode head) {
        
        //store all the elements in monotonic stack i.e. delete smaller elements from the stack if current element is a greater element
        Stack<Integer> stack = new Stack<>();
        ListNode dummy = head;
        
        //iterate list given and insert elements in stack
        while(dummy!=null){
            int curr = dummy.val;
            /*if(stack.isEmpty() || stack.peek() > curr){ 
                stack.push(dummy.val);
                dummy = dummy.next; //move to the next element
            }else{
                //delete all smaller elements from stack
                while(!stack.isEmpty() && stack.peek() < curr){
                    stack.pop();
                }
                stack.push(dummy.val);
                dummy = dummy.next;
            }*/ 
            
            while(!stack.isEmpty() && stack.peek() < curr){
                stack.pop();
            }
            stack.push(dummy.val);
            dummy = dummy.next;
        }
        
        /*ListNode head2 = null;
        if(!stack.isEmpty()){
            head2 = new ListNode(stack.pop());
        }
        
        ListNode dummy2 = head2;
        while(!stack.isEmpty()){
            dummy2.next = new ListNode(stack.pop());
            dummy2 = dummy2.next;
        }
        
        return reverseLinkedList(head2);*/
        
        ListNode reverseHead = null;
        while(!stack.isEmpty()){
            ListNode newNode = new ListNode(stack.pop());
            newNode.next = reverseHead;
            reverseHead = newNode;
        }
        
        return reverseHead;
    }
    
    /*private ListNode reverseLinkedList(ListNode list){
        ListNode prev = null;
        ListNode curr = list;
        ListNode upcoming;
        
        while(curr!=null){
            upcoming = curr.next;
            curr.next = prev;
            prev = curr;
            curr = upcoming; 
        }
        
        return prev;
    }*/
}