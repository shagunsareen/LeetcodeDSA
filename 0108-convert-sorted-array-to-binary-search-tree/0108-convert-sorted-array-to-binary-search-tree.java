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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getConstructedTree(nums, 0, nums.length-1);
    }
    
    
    private TreeNode getConstructedTree(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        
        //we need balanced tree so we need to have root element as mid so that left and right subtree can have same number of elements
        int mid = (start + end)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        //get the left and right subtree
        root.left = getConstructedTree(nums, start, mid-1);
        root.right = getConstructedTree(nums, mid+1, end);
        
        return root;
    }
    
    
}