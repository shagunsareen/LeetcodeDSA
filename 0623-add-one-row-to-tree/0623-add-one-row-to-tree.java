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
    /*public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
           TreeNode newRoot = new TreeNode(val);
           newRoot.left = root;
           return newRoot;
       }  
       return solve(root,val,depth); 
    }
    
    public TreeNode solve(TreeNode root,int val,int depth) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        while(queue.size() > 0) {
            int count = queue.size();
            while(count-- > 0) {
                TreeNode rem = queue.poll();
                if(level == depth-1) {
                    TreeNode left = rem.left;
                    TreeNode right = rem.right;
                    rem.left = new TreeNode(val);
                    rem.right = new TreeNode(val);
                    rem.left.left = left;
                    rem.right.right = right;
                }
                else{
                    if(rem.left != null){
                        queue.add(rem.left);
                    }
                    if(rem.right != null) {
                        queue.add(rem.right);
                    }
                }
            }
            level++;
        }
        return root;
    }*/
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        } 
        // here 1 is the level, we have to insert node when we reach level = depth-1 then only depth of new nodes would be as expected 
        addRowAtDepth(root, val, depth, 1);
        return root;
    }
    
    private void addRowAtDepth(TreeNode node, int val, int depth, int level){
        if(node == null){
            return;
        }
        
        //insert values here 
        if(level == depth-1){
            TreeNode left = node.left;
            TreeNode right = node.right;
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            node.left = newLeft;
            node.right = newRight;
            node.left.left = left;
            node.right.right = right;
            return;
        }else{
            addRowAtDepth(node.left, val, depth, level+1);
            addRowAtDepth(node.right, val, depth, level+1);
        }        
    }
    
}