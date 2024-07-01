class Solution {
    private Queue<int[]> queue = new LinkedList<>(); // store visited cells with x and y in an array
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstX = -1; 
        int firstY = -1;
        
        // Step1 : dfs to get the first island and mark its cell as visited 
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){   
                if(grid[i][j]==1){
                    //we got the first island , go and mark all cells of this island as visited 
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
            
           if(firstX != -1){
                 break;  // break outer loop once the first island is found
            }         
        }
        
        dfs(firstX, firstY, grid, n);
        
        //Step2 : bfs to expand this island to reach another island
        int steps = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                int x2 = curr[0];
                int y2 = curr[1];

                //go in all 4 directions of this cell
                for(int [] nextPair : new int[][]{{x2+1, y2}, {x2-1, y2}, {x2, y2+1}, {x2, y2-1}})
                {  

                    int x3 = nextPair[0];
                    int y3 = nextPair[1];

                    //check if this point is valid and is not visited, if it is not visited then increment the step 
                    if(x3>=0 && y3>=0 && x3<n && y3<n && grid[x3][y3] != 2)
                    {   
                        //if this is 1 then return the steps
                        if(grid[x3][y3]==1)
                        {
                            return steps;
                        }     
                        else if(grid[x3][y3]==0)
                        {
                            queue.add(new int[]{x3, y3});
                            //mark this as visited
                            grid[x3][y3] = 2;
                        }
                    }
                } 
            }
            steps++;
        }
        return -1;
    }
    
    private void dfs(int i, int j, int[][]grid, int n){ 
        //mark the cell as visited
        grid[i][j] = 2;
        
        //add the cell to the queue
        queue.offer(new int[]{i,j});
        
        //go in all 4 directions and mark them as visited 
        for(int[] pair : new int[][]{{i+1, j}, {i-1, j}, {i, j-1}, {i, j+1}}){
          
            //check if the new point is valid or not
            int x1 = pair[0];
            int y1 = pair[1];
            
            if(x1 >=0 && y1>=0 && x1<n && y1<n && grid[x1][y1]==1){  //all valid points
                dfs(x1, y1, grid, n);
            }
        }
    }
    
    
    
    
    
}