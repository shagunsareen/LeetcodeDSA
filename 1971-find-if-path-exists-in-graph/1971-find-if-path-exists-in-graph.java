class Solution {    
    /*private boolean seen;
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i, j;
        
        for(i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
		if(graph[start].contains(end)){  // direct connection exists
             return true;
        }
		
        seen = false;
        dfs(graph, visited, start, end);
        return seen;
    }
    
    private void dfs(HashSet<Integer>[] graph, boolean[] visited, int start, int end){
        if(!visited[start] && !seen){
            if(start == end){
                seen = true;
                return;
            }
            
            visited[start] = true;
            for(Integer neighbor : graph[start]){
                dfs(graph, visited, neighbor, end);
            }
        }
    }*/
    
     public boolean validPath(int n, int[][] edges, int start, int end) {
         if(start == end){
             return true;
         }
         
         //make adjacency list 
         Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
         
         for(int[] edge : edges){
             int u = edge[0];
             int v = edge[1];
             adjacencyMap.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
             adjacencyMap.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
         }
         
         boolean[] visited = new boolean[n];
         return dfs(start, end, adjacencyMap, visited);
     }
    
    private boolean dfs(int start, int end, Map<Integer, List<Integer>> graph, boolean[] visited){
        if(start == end){
            return true;
        }

        visited[start] = true; //mark current node as visited 
        
        //call dfs for adjacent nodes to find the path
        for(Integer neighbor : graph.getOrDefault(start, new ArrayList<>()))
        {
            if(!visited[neighbor])
            { //check if neighbour is not present in the visited array we can iterate on it.
                if(dfs(neighbor, end, graph, visited))
                {
                    return true;
                }  
            } 
        }
        return false;
    }
}