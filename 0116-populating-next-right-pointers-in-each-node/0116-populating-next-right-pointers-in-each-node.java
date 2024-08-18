/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //base case 
        if(root == null){
            return root;
        }
        
        //lets go level wise by traversing to left node of root
        Node currLevel = root; //vertical pointer 
        
        while(currLevel.left!=null){
            
            //To move to every node at a certain level
            Node horizontalLevelNode = currLevel;
            
            while(horizontalLevelNode != null){ //connect nodes at lower level
                horizontalLevelNode.left.next = horizontalLevelNode.right;
                
                if(horizontalLevelNode.next!=null){ 
                    horizontalLevelNode.right.next = horizontalLevelNode.next.left;    
                }
                horizontalLevelNode = horizontalLevelNode.next; //move to next node
            }
            
            //when nodes at a level are over and we have reached null move to next level
            currLevel = currLevel.left;     
        }
        
      return root;  
    }
}