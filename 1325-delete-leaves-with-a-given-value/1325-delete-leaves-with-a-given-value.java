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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        //base case
        if(root == null){
            return null;
        }
        
        //go to left subtree and delete target nodes
        root.left = removeLeafNodes(root.left, target);
        //go to right subtree and delete target nodes
        root.right = removeLeafNodes(root.right, target);
        
        //check if this is target node
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        
        //otherwise
        return root;
    }
}