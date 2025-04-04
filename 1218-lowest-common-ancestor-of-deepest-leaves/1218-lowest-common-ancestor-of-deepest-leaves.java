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
    static class Pair{
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair res = findLCA(root);
        return res.node; //since we need to return node and not just value so we store node and its depth in the Pair class
    }

    private Pair findLCA(TreeNode root){
        if(root == null){
            return new Pair(null, 0);
        }

        Pair left = findLCA(root.left); //get subtree length of left and right
        Pair right = findLCA(root.right);

        if(left.depth == right.depth){
            //then root is the LCA if both substrees length is same
            return new Pair(root, 1 + left.depth);
        }else if(left.depth > right.depth){
            return new Pair(left.node, 1 + left.depth);
        }else{
            return new Pair(right.node, 1 + right.depth);
        }
    }
}