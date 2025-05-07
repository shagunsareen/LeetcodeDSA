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
        Node curr = head;

        //1. create all new nodes , attach after original nodes
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next; //move to next original node
        }

        //2. add random ptrs now we have all nodes
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next; //since copied nodes are next ones to original ones
            } 
            curr = curr.next.next;
        }

        //3. extract copied list from original 
        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;

        while(curr != null){
            copyCurr.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummyHead.next;
    }
}