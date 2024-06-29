class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> current = new ArrayList<>();
        current.add(0);
        dfs(0, graph, current);
        return result;
    }
    
    private void dfs(int source, int[][] graph, List<Integer> current){ 
        if(source == graph.length-1){
            //if we have traversed all nodes
            result.add(new ArrayList<>(current));
            return;
        }
        
        //go and traverse all neighbours of source
        for(int adjacentNode : graph[source]){
            //go and traverse neighbours to get a new path
            current.add(adjacentNode);
            dfs(adjacentNode, graph, current);
            current.remove(current.size()-1);
        } 
    }
}