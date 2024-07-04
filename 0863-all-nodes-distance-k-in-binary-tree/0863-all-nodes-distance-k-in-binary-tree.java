/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, root, parentMap);
        
        //now we have to traverse tree again starting from target - BFS to find shortest path to get k distant nodes
        Queue<TreeNode> queue = new LinkedList<>(); 
        Set<TreeNode> visited = new HashSet<>(); 
        queue.add(target);
        visited.add(target);
        
        int level = 0;
        
        while(!queue.isEmpty()){
            if(level==k) return buildListFromQ(queue);
            
            int size = queue.size(); 
            for(int i=0; i<size; i++){ //check all nodes at a particular distance together and then move to the next level 
                TreeNode current = queue.poll();
                
                if(current.left!=null && !visited.contains(current.left)){
                    queue.add(current.left);
                    visited.add(current.left);
                }
                if(current.right!=null && !visited.contains(current.right)){
                    queue.add(current.right);
                    visited.add(current.right);
                }
                TreeNode parent = parentMap.get(current);
                if(parent!=null && !visited.contains(parent)){
                    queue.add(parent);
                    visited.add(parent);
                }
            } 
            level++;
        }       
        return res;
    }
    
    //build parent root map to know at any point who is the parent of the current node to check radially outward nodes
    private void buildParentMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap){
        if(root == null)
            return;
        //pre-order traversal since order doesn't matter 
        parentMap.put(root, parent);
        buildParentMap(root.left, root, parentMap);
        buildParentMap(root.right, root, parentMap);
    }
    
    private List<Integer> buildListFromQ(Queue<TreeNode> queue){  
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll().val);
        }    
        return res;
    }
}