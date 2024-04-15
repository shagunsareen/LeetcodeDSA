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
    StringBuilder str = new StringBuilder();
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {  
        getSum(root);
        return sum;
    }
    
    
    private void getSum(TreeNode root){
        //base case 
        if(root == null)
        { 
            return; 
        }
        
        str.append(root.val);
        
        //if we reach leaf node 
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(str.toString());
            //System.out.println(str.toString());
        }

        getSum(root.left); 
        getSum(root.right);
        str.deleteCharAt(str.length() - 1);
    }
}