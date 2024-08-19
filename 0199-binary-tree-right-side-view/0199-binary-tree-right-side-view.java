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
    ArrayList<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        TreeNode curr = root;
        TreeNode dummy = new TreeNode(-1);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(curr);
        queue.add(dummy);
        res.add(curr.val); //since root node will be in the ans anyway
        
        while(!queue.isEmpty()){
            
            curr = queue.poll();
            //System.out.println(curr.val);
            
            if(curr!=dummy){
                //System.out.println("Not inside dummy");
                
                if(curr.right != null){  //add the right node first 
                    queue.add(curr.right);
                }
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
            }else{
                //System.out.println("inside dummy");
                
                if(!queue.isEmpty()){
                    queue.add(dummy);
                     //res.add(queue.peek().val); 
                }
                
                if(queue.peek() != null){
                   res.add(queue.peek().val); //this is right node of the level since we added right node first to the queue 
                } 
            }
        }
        return res;    
    }
}