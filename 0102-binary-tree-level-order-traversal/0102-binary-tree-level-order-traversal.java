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
    
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null){
            return Collections.emptyList();    
        }
        
        res = new ArrayList<>();
        ArrayList<Integer> subres = new ArrayList<>();
        
        TreeNode node = root;
        TreeNode dummy = new TreeNode(-1);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(dummy);
        
        while(!queue.isEmpty()){
            
            TreeNode curr = queue.poll();
            
            if(curr == dummy){
                //one level is traversed
                //save list to ansList
                res.add(subres);
                subres = new ArrayList<>(); //reinitialise for new level
                
                if(!queue.isEmpty()){
                    queue.add(dummy);
                }
            }else{
                subres.add(curr.val);
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }     
            }
        }    
        return res;
    }
}