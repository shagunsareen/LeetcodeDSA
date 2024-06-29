class Solution {
    public int minReorder(int n, int[][] connections) {
        
        //make the adjacencey list and mark nodes from parent to child as positive and negative otherwise
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int[] edge : connections){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(-edge[0]); //child to parent doesn't need to reverse
        }
        
        return dfs(adjacencyList, new boolean[n], 0); //start from root node i.e. 0
    }
    
    //this function should calculate the no. of edges that has to be reversed
    private int dfs(List<List<Integer>> adjacencyList, boolean[] visited , int root){
        int change  = 0;
        visited[root] = true;    
        //get the number of edges to be changed for each neighbour
        for(int adjacentNode : adjacencyList.get(root)){
            //if a node is already traversed then we don't have to count that edge to be reversed again 
            if(!visited[Math.abs(adjacentNode)])
            {
                int childsRevEdgeCount = adjacentNode > 0 ? 1 : 0; // if the node is from parent to child then take the count as 1 because we have to reverse this node else if it is from child to parent then we dont have to reverse it
                int childsAdjRevEdgeCount = dfs(adjacencyList, visited, Math.abs(adjacentNode));  
                change += childsRevEdgeCount + childsAdjRevEdgeCount;
            }
        }   
        return change;
    }
}