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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        } 
        return iterate(root, targetSum);
    }
    
    
    private boolean iterate(TreeNode root, int targetSum){
        if(root.left == null &&  root.right == null && targetSum - root.val == 0){
            //System.out.println("TargetSum : "+ targetSum+ "Root : "+ root.val);
            return true;
        }
        
        if((root.left != null && iterate(root.left, targetSum - root.val)) || 
           (root.right != null && iterate(root.right, targetSum - root.val)))
        {
           return true;
        }
        
        return false;
    }
}