class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        //we have to traverse all the nodes and at the end we will see whether all nodes are visited or not
        int n = rooms.size();
        
        int[] visited = new int[n];
          
        dfs(0, rooms, visited);
 
        //check if all the nodes are visited or not
        for(int i = 0; i<visited.length; i++){
            if(visited[i] == 0){
                return false;
            }
        }    
        return true;
    }
    
    private void dfs(int currRoom, List<List<Integer>> rooms, int[] visited){
        //mark the current node as visited
        visited[currRoom] = 1;
        
        //check all other rooms 
        for(int roomKey : rooms.get(currRoom)){
            if(visited[roomKey] == 0){
                dfs(roomKey, rooms, visited);
            }
        }
    }
}