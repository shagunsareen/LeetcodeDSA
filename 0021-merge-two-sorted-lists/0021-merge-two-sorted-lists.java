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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
        {
            return list1;
        }

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode mergedHead = new ListNode(0); //dummy head
        ListNode mergedPtr = mergedHead;

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        if(ptr1.val <= ptr2.val){
            mergedPtr.next = ptr1;
            ptr1 = ptr1.next;  
        }else{
            mergedPtr.next = ptr2;
            ptr2 = ptr2.next;
        }

        mergedPtr = mergedPtr.next;

        while(ptr1 != null && ptr2 != null){//compare both lists 
            if(ptr1.val <= ptr2.val){
                mergedPtr.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                mergedPtr.next = ptr2;
                ptr2 = ptr2.next;
            }
            mergedPtr = mergedPtr.next;
        }

        mergedPtr.next = (ptr1 != null) ? ptr1 : ptr2;
        
        return mergedHead.next;
    }
}