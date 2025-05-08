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
        
        /*
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
        */

        //Approach 2 - merge using priority queue

        //insert head of all lists to queue and pick smallest one always
        PriorityQueue<ListNode> queue = new PriorityQueue<>((b,c) -> b.val - c.val); //increasing order 
        for(ListNode node : lists){
            if(node != null){
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;

        while(!queue.isEmpty()){
            pointer.next = queue.poll(); //head
            pointer = pointer.next; //next node should be here 

            //we have picked 1 ele out of k now we have to insert next ele also of the list
            if(pointer.next != null){
                queue.add(pointer.next);
            }
        }

        return dummy.next;
    }
}