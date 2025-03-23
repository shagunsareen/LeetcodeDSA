/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //Step1 : create copy of each node in place to original list
        Node curr = head;

        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            // node.random = originalPtr.random; // this can't be done since random is another node in the same list so we first need to create all nodes in the new lis t

            curr.next = copy; //assign copy node just next to it's original node
            curr = copy.next;
        }

        //Step2 : Assign random pointer to the copied nodes
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next; //since curr's random's next node would eb the copied node of original random node and we need to point to copied nodes not the original ones
            }
            curr = curr.next.next;
        }

        //Step3 : extract copied list from original list 
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while(curr != null){
            copyCurr.next = curr.next;
            curr.next = curr.next.next; //restoring the original list (removing copied nodes)
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return dummy.next;
    }
}