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
    //LEVEL ORDER TRAVERSAL
    List<List<Integer>> res;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
       
        ArrayList<Integer> subres = new ArrayList<>();
        
        TreeNode curr = root;
        TreeNode dummy = new TreeNode(-1);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(curr);
        queue.add(dummy);
        
        boolean reverse = false;
        
        while(!queue.isEmpty()){
            curr = queue.poll();
            
            if(curr!=dummy){
                subres.add(curr.val); //add nodes of one level into this subres list 
                    
                if(curr.left != null){
                    queue.add(curr.left);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }else{
                //check whether to reverse the list or not before saving
                if(reverse){
                    Collections.reverse(subres);
                }
                
                res.add(subres);
                subres = new ArrayList<Integer>();
                
                if(!queue.isEmpty()){
                    queue.add(dummy);
                }
                
                reverse = !reverse;
            }
        }
        
        return res;
    }
}