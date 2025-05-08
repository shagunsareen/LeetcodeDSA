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
    public ListNode mergeKLists(ListNode[] lists) {

        //Approach 1 : TC - NlogN, SC - N
        //put all nodes in one list and sort it 
        ArrayList<Integer> nodes = new ArrayList<>();
        for(ListNode l : lists){
            while(l != null){
                nodes.add(l.val);
                l = l.next;
            }            
        }

        Collections.sort(nodes);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        //now create list from these sorted nodes
        for(int x : nodes){
            curr.next = new ListNode(x);
            curr = curr.next;
        }

        return dummy.next;
    }
}