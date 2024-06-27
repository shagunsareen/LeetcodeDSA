class Solution {
    public int findCircleNum(int[][] isConnected) {
        //to find no. of provinces means to find number of connected components since a province is made of connected nodes
        int n = isConnected.length;
        int[] visited = new int[n+1];
        int provincesCount = 0;
        
        //check for all the cities and mark them as visited 
        for(int i=0; i<n; i++){
            //check if this is not visited 
            if(visited[i] == 0){
                //traverse all connected nodes
                provincesCount++;
                dfs(i, isConnected, visited);
            }
        }
        
        return provincesCount;
    }
    
    private void dfs(int node, int[][] isConnected, int[] visited){ 
        //mark the node as visited
        visited[node] = 1;
        
        //check for connected nodes 
        for(int i=0; i<isConnected.length; i++){   
            if(isConnected[node][i] == 1 && visited[i] == 0){
                dfs(i, isConnected, visited);
            }
        }
    }
}