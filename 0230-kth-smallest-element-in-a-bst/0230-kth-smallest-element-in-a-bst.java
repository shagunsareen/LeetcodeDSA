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
    List<Integer> inorderList;
    public int kthSmallest(TreeNode root, int k) {
        inorderList = new ArrayList<Integer>();
        inorderTraversal(root);
        //System.out.println(inorderList.toString());
        
        //since the inorder traversal of BST should be in increasing order we can directly get value 
        return inorderList.get(k-1);    
    }
    
    private void inorderTraversal(TreeNode root){
        if(root == null)
            return;
        
        inorderTraversal(root.left);
        inorderList.add(root.val);
        inorderTraversal(root.right);
    }
}