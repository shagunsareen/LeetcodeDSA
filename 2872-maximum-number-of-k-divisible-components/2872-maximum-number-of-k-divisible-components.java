class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        //Step 1 : Create adjacency list from the edges
        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        //insert the edges for the nodes
        for(int[] edge: edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        //Step2 : Initialise component count
        int[] componentCount = new int[1];
        
        //Step3 : Start the DFS traversal from the node 0 as this is an undirected graph traversal can be done from any node 
        dfs(0, -1, adjList, values, k, componentCount);
        
        //Step4 : Return the total number of components
        return componentCount[0];
    }
    
    private int dfs(int currentNode, int parentNode, List<Integer>[] adjList, int[] nodeValues, int k, int[] componentCount){
        
        //Initialise sum for current subtree
        int sum = 0;
        
        //traverse all the neigbhours
        for(int neighbour : adjList[currentNode]){            
            //you can't go back to the same node from where you came to this currentnode
            if(neighbour != parentNode){
                 sum += dfs(neighbour, currentNode, adjList, nodeValues, k, componentCount);
                 sum %= k; //ensure that the sum stays withing the bound;
            }
           
        }
        
        //subtree sum we got now add currentnode value to the sum 
        sum += nodeValues[currentNode];
        sum %= k;
        
        //check if the sum is divisible by k
        if(sum == 0){
            componentCount[0]++;
        }
        
        //return the computed sum 
        return sum;
    }
}