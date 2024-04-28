class Solution {
    int[] res, count;
    ArrayList<HashSet<Integer>> tree;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        //https://leetcode.com/problems/sum-of-distances-in-tree/discuss/885637/Java-solution-code-%2B-photo-explaination
        //https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and-Post-order-DFS-O(N)
        //make adjacency list
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[n]; //sum of distance of all nodes from the root in a subtree
        count = new int[n]; //count of nodes in subtree
        
        //create empty hashset for each node
        for(int i=0; i<n; i++){
            tree.add(new HashSet<Integer>());
        }
        
        //insert elements to each hashset
        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        //now we have adjacency list complete 
        postOrderDfs(0, -1); //this is to update count and res for root 0
        preOrderDfs(0, -1); //this is to update res for each node as root using root 0 sum
        
        return res;
    }
    
    private void postOrderDfs(int root, int prev){
        //traverse adjacent elements for the root
        for(int i : tree.get(root)){
            //edge case
            if(i == prev) continue;
            
            //else go and iterate for adjacent element
            postOrderDfs(i, root);
            count[root] += count[i]; //adding count of nodes in subtree for current root including subtree root, if it is count[3] then it includes count of nodes in subtree including node 3
            res[root] += res[i] + count[i]; // sum of distance of nodes from root can be calculated using sum of subtree root and add count of 
        }
        count[root]++; // to include the curr root in the count of subtree 
    }
    
    private void preOrderDfs(int root, int prev){
        //now get the sum of all rest nodes keeping each node as the root using sum of root 0
        for(int i : tree.get(root)){
            if(i == prev) continue;
            //number of nodes closer to root is count[i] and farther from root is total - closer nodes
            res[i] = res[root] - count[i] + (count.length - count[i]); 
            preOrderDfs(i, root); //calculate sum for adjacent nodes also
        }
    }
}
    
    
    