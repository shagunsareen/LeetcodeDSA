/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
    
    
    private TreeNode delete(TreeNode root, int key){
        //if root is null 
        if(root == null){
            return null;
        }
        
        //find the treeNode first 
        if(root.val < key){
           root.right = delete(root.right, key);
        }else if(root.val > key){
           root.left =  delete(root.left, key);
        }else if(root.val == key){
            //now that we have the node to delete we will see if it has some dependencies before we mark it null
            //check if it has any children, only 1 children or no children
            
            if(root.left == null && root.right == null){ //0 child
                root = null; //delete the node directly
            }else if(root.left == null){ // 1 child
                root = root.right;
            }else if(root.right == null){ // 1 child 
                root = root.left;
            }else{
                //2 children
                //To replace it with some node, we need to find max of LST or min of RST and replace it with root
                //Then delete the node in LST or RST which just replaced the root node
                root.val = findMaxInLst(root.left).val;
                root.left = delete(root.left, root.val);
            }    
        }  
        return root;
    }
    
    //since max in LST will be at the right so we will just iterate the right subtree further
    private TreeNode findMaxInLst(TreeNode node){
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }
    
    
}