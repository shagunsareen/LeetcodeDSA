class Solution {
    public int minimumTime(int[][] grid) {
        
        int[][] directions = {{0,1}, {0,-1}, {-1, 0}, {1,0}};
        int n = grid.length;
        int m = grid[0].length;
        
        if (grid[0][1] > 1 && grid[1][0] > 1){           
            return -1;
        }
        
        //ordered by time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]); //array : row, col, time
        
        boolean[][] visited = new boolean[n][m];
        
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int time = curr[2];
            
            //if we have reached the target then return 
            if(row == n-1 && col == m-1)
                return time;
            
            //check if it is already visited
            if(visited[row][col]) continue;
            visited[row][col] = true;
            
            //else go and check neighbours of the current cell
            for(int[] direction : directions){
                
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                //check if the indexes are valid 
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]){
                    int newTime = 0;
                    
                    //time required to move to next cell, we move 1 step at a time so if time req to go to next cell is curr time + 1 or                                                            lesser than curr time then we can go there as this seems reachable 
                       
                    /*int diff = grid[newRow][newCol] - time; 
                    if(diff<=1){
                        newTime = time + 1; //cell is reachable & time will increase by 1
                    }else{
                        newTime = time+1+(diff/2)*2; //we have to wait till time diff is <=1
                    }*/
                    
                    newTime = time + 1;
                    if(grid[newRow][newCol] > newTime){//even if we take next step we can't visit next node so wait
                        newTime = (grid[newRow][newCol] - time)%2!=0 ? grid[newRow][newCol] : grid[newRow][newCol] + 1;
                    }
                    
                    pq.add(new int[]{newRow, newCol, newTime});
                }   
            }
        }
       return -1; 
    }
 
}