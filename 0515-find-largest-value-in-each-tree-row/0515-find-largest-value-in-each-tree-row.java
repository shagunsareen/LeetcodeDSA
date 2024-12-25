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
    public List<Integer> largestValues(TreeNode root) {
        
        //since constraints tell nodes can be 0 so root can be null
        if(root == null)
            return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();       
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int levelMax = Integer.MIN_VALUE;
            
            for(int i=0; i<size; i++){ //traverse all nodes of this level 
                TreeNode curr = queue.poll();
                levelMax = Math.max(levelMax, curr.val);  
                
                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            
            ans.add(levelMax);
        }
        
        return ans;
    }
}