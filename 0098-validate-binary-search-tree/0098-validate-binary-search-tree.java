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
    List<Integer> result;
    public boolean isValidBST(TreeNode root) {
        result = new ArrayList<Integer>();
        return checkOrder(root);
    }
    
    
    private boolean checkOrder(TreeNode root){
        inorderTraversal(root);
        
        //check if list has only one element
        if(result.size()==1){
            return true;
        }
        
        System.out.println(result.toString());
        
        //check if the inorder Traversal is in increasing order
        for(int i=1; i<result.size(); i++){ 
            //compare 2 elements at a time 
            if(result.get(i) <= result.get(i-1)) { //consider = here since binary search tree should not have same elements
                return false;
            }
        }   
        return true;
    }
    
    
    private void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }
}