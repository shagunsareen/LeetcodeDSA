class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        //create adjacencyList
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjacencyList.add(new ArrayList<>()); 
        }
        
        for(int[] road : roads){
            adjacencyList.get(road[0]).add(road[1]);
            adjacencyList.get(road[1]).add(road[0]); // undirected graph
        }
        
        int maxRank = Integer.MIN_VALUE;
        
        //now we have degree of every node
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){ //i+1 since we have to check with other nodes/cities and not the same city
                int city1Count = adjacencyList.get(i).size();
                int city2Count = adjacencyList.get(j).size();
                
                int count = city1Count + city2Count;
                
                //exclude 1 from count if there is a direct road between i and j
                if(adjacencyList.get(i).contains(j)){
                    count--;
                }
                
                maxRank = Math.max(maxRank, count);
            }
        }
        
        return maxRank;
    }
}