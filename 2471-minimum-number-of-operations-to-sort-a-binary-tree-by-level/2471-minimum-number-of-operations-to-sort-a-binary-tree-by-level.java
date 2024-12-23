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
    public int minimumOperations(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minCount = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                levelList.add(curr.val);
                
                if(curr != null){
                    if(curr.left != null)
                        queue.add(curr.left);
                    if(curr.right != null)
                        queue.add(curr.right);
                }   
            }
            
            minCount += minStepsToSort(levelList);
        }
        
        return minCount;
    }
    
    
    private int minStepsToSort(List<Integer> list){
        //Create map to store original index of each treenode 
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sortedList = new ArrayList<>(list);
        
        //store the original index of each element
        for(int i=0; i<list.size(); i++){
            map.put(list.get(i), i);
        }
        Collections.sort(sortedList);
        int count = 0;
        
        //now compare original index and index of the element in sorted list 
        //if its not same then swap the elements
        for(int i=0; i<sortedList.size(); i++){
            int currEle = list.get(i); // 7 
            int correctEle = sortedList.get(i); //5
            
            if(currEle != correctEle){
                int correctIndex = map.get(currEle);  // ele 7 , index : 0
                int wrongIndex = map.get(correctEle); //ele 5 , index : 3
                
                //swap both
                map.put(correctEle, correctIndex);
                map.put(currEle, wrongIndex);
                
                list.set(correctIndex, correctEle);
                list.set(wrongIndex, currEle);
                
                count++;
            }
        }
        return count;
    }
}