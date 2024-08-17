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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;   
       
       //swap left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        //do the same thing for rest of the subtrees 
        invertTree(root.left); //do the same thing for left subtree
        invertTree(root.right); //do the same thing for right subtree
        
        return root;
    }
}