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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        //level order traversal 
        TreeNode dummy = new TreeNode(-1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(dummy);

        List<Integer> res = new ArrayList<>();
        res.add(root.val);

        while(!queue.isEmpty()){

            TreeNode curr = queue.poll();
            
            if(curr == dummy){ 
                if(!queue.isEmpty()){
                    queue.add(dummy);
                }

                if(queue.peek() != null){
                    res.add(queue.peek().val);
                }
            }else{
                if(curr.right != null){
                    queue.add(curr.right);
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }     
            }   
        }
        return res;
    }
}