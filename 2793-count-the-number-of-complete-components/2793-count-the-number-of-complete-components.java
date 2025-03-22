class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        //create adjacency list
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int connectedComponents = 0;

        //add the edge from both a to b and from b to a 
        for(int[] edge : edges){
           adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
           adjMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n+1];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                int[] nodes = new int[1];
                int[] edgeCount = new int[1];
                dfs(nodes, edgeCount, adjMap, visited, i);

                //check if all edges are connected
                if(edgeCount[0] == nodes[0]*(nodes[0]-1)){
                    connectedComponents++;
                }
            }
        } 
        return connectedComponents;
    }

    private void dfs(int[] nodes, int[] edgeCount, Map<Integer, List<Integer>> adjMap, boolean[] visited, int currNode){
        visited[currNode] = true;
        nodes[0]++;
        //check if it has neighbours then traverse neighbours till all are not done
        if(adjMap.containsKey(currNode)){
            for(Integer neighbourNode : adjMap.get(currNode)){
                edgeCount[0]++; //since its neighbout there must have been an edge between both nodes as per the question
                if(!visited[neighbourNode]){
                    dfs(nodes, edgeCount, adjMap, visited, neighbourNode);
                }
            }
        }   
    }
}