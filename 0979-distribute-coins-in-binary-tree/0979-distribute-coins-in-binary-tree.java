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
    int moves;
    public int distributeCoins(TreeNode root) { 
       moves = 0;
       dfs(root);
       return moves; 
    }
    
    private int dfs(TreeNode current){
        if(current == null) return 0; //no coins required to be exchanged
        int leftCoins = dfs(current.left); //no. of coins the left subtree needs to exchange  
        int rightCoins = dfs(current.right); //no. of coinds the right subtree needs to exchange
       
        // Add the total number of exchanges to moves
        moves += Math.abs(leftCoins) + Math.abs(rightCoins);
        
        // The number of coins current has available to exchange
        return (current.val-1) + leftCoins + rightCoins;
    }
}