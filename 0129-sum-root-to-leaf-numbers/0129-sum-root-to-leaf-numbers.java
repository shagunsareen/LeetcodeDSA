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
    public int sumNumbers(TreeNode root) {
        
       return  sum(root , 0);
        
    }
    
    public int sum(TreeNode root , int currentSum){
        if(root == null){
            return 0;
        }
        
         currentSum = currentSum * 10 + root.val;
        
        if(root.right == null && root.left ==null){
            return currentSum;
        }
        
        return sum(root.left , currentSum) + sum(root.right , currentSum);
    }
}