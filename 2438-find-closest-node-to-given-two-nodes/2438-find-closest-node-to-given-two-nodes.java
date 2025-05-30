class Solution {
    //bi directional BFS 
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        //we will find shortest distance of each node from both given starting nodes
        //then we find max value out of both distances
        //then we take min of max values 
        
        //store shortest distance in an array of col size 2 for all nodes n 
        int n = edges.length;
        int[][] dist = new int[n][2]; //row - number of nodes, col - type of input nodes
        
        for(int[] row : dist){
            Arrays.fill(row, -1);
        }

        dist[node1][0] = 0; //distance of first node from itself 
        dist[node2][1] = 0; //distance of second node from itself

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node1, 0});
        queue.offer(new int[]{node2, 1}); //type is required to store distance of each node properly

        while(!queue.isEmpty()){
            int size = queue.size();
            int[] curr = queue.poll();
            int node = curr[0];
            int type = curr[1];

            //check edge as it can be 0 or 1 
            int neighbour = edges[node]; //edges of certain node are at its index in edge array
            if(neighbour != -1 && dist[neighbour][type] == -1){ //edge exits and is not visited
                dist[neighbour][type] = dist[node][type] + 1;
                queue.offer(new int[]{neighbour, type});
            }
        }

        //now we have distances from both nodes 
        //if both nodes distance have value then compare 
        int ans = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<n; i++){
            if(dist[i][0] != -1 && dist[i][1] != -1){
                int currMax = Math.max(dist[i][0], dist[i][1]);
                if(currMax < ans){
                    ans = currMax;
                    index = i;
                }
            }
        }

        return index;
    }
}