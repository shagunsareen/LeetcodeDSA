class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Collections.singletonList(0);
        
        //make adjacency list
        ArrayList<HashSet<Integer>> adj = new ArrayList<>(n);
        for(int i=0; i<n; i++) adj.add(new HashSet<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        //get the leaf nodes 
        for(int i=0; i<n; i++){
            if(adj.get(i).size() == 1) leaves.add(i);
        }
        
        //There can be either 1 root node or 2 root nodes which will have minimum height trees
        //remove leave nodes, add new leaves nodes till we get center root nodes
        while(n>2){
            n -= leaves.size(); //these many nodes will be excluded from the ans
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves){
                //get the next adjacent node and remove curr node from it's list 
                int nextNode = adj.get(i).iterator().next();
                adj.get(nextNode).remove(i); 
                if(adj.get(nextNode).size() == 1) newLeaves.add(nextNode);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}