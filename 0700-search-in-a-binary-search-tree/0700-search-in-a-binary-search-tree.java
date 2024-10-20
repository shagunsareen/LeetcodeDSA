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
    public TreeNode searchBST(TreeNode root, int val) {
        return checkIfNodeExists(root, val);
    }
    
    private TreeNode checkIfNodeExists(TreeNode root, int val){
        
        if(root == null || root.val == val){
            return root;
        }else if(root.val < val){
            //go to right subtree
            return checkIfNodeExists(root.right, val);
        }else if(root.val > val){
            return checkIfNodeExists(root.left, val);
        }
        
        return root;
    }
}