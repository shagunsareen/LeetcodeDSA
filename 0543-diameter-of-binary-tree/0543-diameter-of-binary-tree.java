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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node){
        if(node == null) return -1;

        int lp = longestPath(node.left);
        int rp = longestPath(node.right);

        diameter = Math.max(diameter, lp + rp + 2); // we add 2 to count edges to the parent node

        return Math.max(lp, rp) + 1; //we take one path which is longer and we add edge to parent node
    }
}