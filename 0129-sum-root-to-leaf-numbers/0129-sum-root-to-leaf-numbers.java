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
    /*public int sumNumbers(TreeNode root) {       
       return sum(root , 0);     
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
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int sumNumbers(TreeNode root) {       
       return sum(root , 0);     
    }
    
    private int sum(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        
        //create sum including current node val
        sum = sum*10 + node.val;
        
        //check if you have reached leaf node then create the number
        if(node.left == null && node.right == null){
            return sum;    
        }
        
        int leftSum = sum(node.left, sum);
        int rightSum = sum(node.right, sum);
        
        return leftSum + rightSum;
    }
    
    
    
    
    
    
}