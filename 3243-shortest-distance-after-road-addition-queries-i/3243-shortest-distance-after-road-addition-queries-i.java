class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        //Step 1 : get adjacency matrix for the graph 
        //Step 2 : consider the queries mentioned in input array one by one & include it in adjacency matrix
        //Step 3 : then run BFS
        //Step 4 : store shortest distance in every iteration in an array 
       
        int size = queries.length;
        
        //int[] res = new int[size];
        ArrayList<Integer> answer = new ArrayList<>();
        
        //Step 1 : get adjacency matrix for the graph 
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());  //initialise adjacency list 
        }
        
        for(int i=0; i<n-1; i++){ //since last node doesn't have outward edge hence loop will be till n-1
            adjList.get(i).add(i+1);
        }
        
        //Step 2 : Add queries mentioned in input array in adjacency matrix
        for(int[] road : queries){
            adjList.get(road[0]).add(road[1]); //Add road to the graph 
            
            //now do BFS to find shortest path to end node
            answer.add(bfs(n, adjList));
            
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    
    private int bfs(int n , List<List<Integer>> adjList){
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(0);
        visited.add(0);
        
        int moves = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- != 0) {
                
                int currNode = queue.poll();
                
                if(currNode == n-1){ //check if we have reached the target
                    return moves;
                }
                
                //explore adj nodes 
                for(int neighbour : adjList.get(currNode)){   
                    //check if neighbour is not visited 
                    if(visited.contains(neighbour)) continue;
                    
                    //else add it to queue and mark it visited
                    queue.add(neighbour);
                    visited.add(neighbour);
                }                   
            }
            
            moves++;
        }
        
        return -1;
    }
    
}