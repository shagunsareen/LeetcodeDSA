class Solution {
    public boolean isBipartite(int[][] graph) {
        
        //graph is a bipartite if we can divide it into 2 halves and if we can color it with 2 colors
        //we will color the parent node as one color and child nodes as different color and if till the end no child color matches parent color it means it is a bipartite graph 
        //we already have adjacency list as input graph , we just have to pick the starting node and start coloring
        
        int n = graph.length;
        int[] visited = new int[n]; //array to check cell is visited or not and which color it has 0 or 1
        Arrays.fill(visited, -1);
        
        //for each disconnected components
        for(int i=0; i<n; i++){
            if(visited[i]==-1)
                if(!bipartiteCheck(i, graph, visited, 0))
                    return false;
        }
        
        return true;
    }
    
    private boolean bipartiteCheck(int node, int[][] graph, int[] visited, int color){   
        //visit the node
        visited[node] = color;
        
       //go and color child nodes
        for(int childNode : graph[node]){
            
            //check if it is visited or not
            if(visited[childNode]==-1){
                //color the childnode
                if(!bipartiteCheck(childNode, graph, visited, color^1))
                    return false;
            }else{
                if(visited[childNode] == visited[node])
                    return false; //since it is not bipartite node as the edge contains same color for both nodes
            }
            
        }
        
        return true;
    }
}