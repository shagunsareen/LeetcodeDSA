class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){ // n is the length of colors string i.e. those many nodes we will take into consideration
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]); // node -> neighbour 
        }

        int[][] longest = new int[26][n]; // here value in cell will denote max count of i color nodes from current node path j 

        //perform dfs from each node & maximize color length
        int[] visited = new int[n];
        int maxColorLength = 0;

        //    3-color method is used to detect cycle in directed graph.
        //    0: Unvisited
        //    1: Visited & Processing
        //    2: Visited & Processed
        for(int i=0; i<n; i++){
            int res = dfs(i, adj, visited, longest, colors);
            if(res == Integer.MAX_VALUE){ //if there is a cycle in graph return -1 
                return -1;
            }
            maxColorLength = Math.max(maxColorLength, res);
        }
        return maxColorLength;
    }

    private int dfs(int curr, List<List<Integer>> adj, int[] visited, int[][] longest, String colors){
        if(visited[curr] == 1){
            return Integer.MAX_VALUE; //cycle detected
        }

        if(visited[curr] == 0){ //1st time
            //mark it visited
            visited[curr] = 1;
            //go to all its adjacent nodes and update max value 
            for(int nbr : adj.get(curr)){
                    int res = dfs(nbr, adj, visited, longest, colors);
                    if(res == Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                    
                    //if no cycle is returned then update max colors value for curr node for all colors with whatever path from this node to end has max values 
                    for(int i=0; i<26; i++){
                        longest[i][curr] = Math.max(longest[i][curr], longest[i][nbr]);
                    }
            }
            longest[colors.charAt(curr) - 'a'][curr]++; //incrementing value for curr node color 
            visited[curr] = 2;
        }
        return longest[colors.charAt(curr) - 'a'][curr];
    }
}