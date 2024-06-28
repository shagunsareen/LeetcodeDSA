class Solution {
   /* public List<Integer> eventualSafeNodes(int[][] graph) {
   
    // Link : https://takeuforward.org/data-structure/find-eventual-safe-states-dfs-g-20/
        //if there is a cycle in the graph then those nodes can't be considered as safe nodes , for all other nodes which are not in cycle mark them as safe nodes
       int n = graph.length;
       int[] visited = new int[n]; //nodes start from 0 
       int[] checkNodes = new int[n]; //to store the status of nodes as safe or not
       
        //check all components
       for(int i=0; i<n; i++){
           if(visited[i] == 0){
               dfs(i, graph, visited, checkNodes);
           }
       }
        
        ArrayList<Integer> safeNodes = new ArrayList<>();
        
        //return safe nodes
        for(int i=0; i<checkNodes.length; i++){
            if(checkNodes[i] == 1){
                safeNodes.add(i);
            }
        } 
        return safeNodes;
    }
    
    private boolean dfs(int node, int[][] graph, int[] visited, int[] checkNodes){   
        //mark this visited
        /*visited[node] = 1;
        checkNodes[node] = 0;
        
        //check neighbouring nodes
        for(int adjacentNode : graph[node]){     
            if(visited[adjacentNode] == 1){
                return true;
            }else if(visited[adjacentNode] != 1){
                if(dfs(adjacentNode, graph, visited, checkNodes)){
                    return true;
                }
            }
        }*/
        
       /* if (visited[node] == 1) {
            return true; // Cycle detected
        }
        if (visited[node] == 2) {
            return false; // Already determined to be safe
        }

        visited[node] = 1; // Mark as visiting
        for (int adjacentNode : graph[node]) {
            if (dfs(adjacentNode, graph, visited, checkNodes)) {
                return true;
            }
        }
        
        
        //no cycle is detected meaning the node is safe node and all nodes prior to this are also safe nodes 
        //unvisit it from the current path
        visited[node] = 2;
        checkNodes[node] = 1;
        return false;
    }*/
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n = graph.length;
       int [] safe = new int[n]; //nodes start from 0 
       ArrayList<Integer> list = new ArrayList<>();
        
       for(int i=0; i<n; i++){
             if(dfs(i, graph, safe)){ //true meaning its safe node
                 list.add(i);
             }
       }   
       return list;
    }
    
     private boolean dfs(int node, int[][] graph, int[] safe){ 
        if(safe[node] != 0){
            return safe[node] == 2;
        }
    
        safe[node] = 1; //unsafe
        //check neighbouring nodes
        for(int adjacentNode : graph[node]){  
                if(!dfs(adjacentNode, graph, safe)){
                    return false;
                }
         }       
         safe[node] = 2; // safe
         return true;
     }
}