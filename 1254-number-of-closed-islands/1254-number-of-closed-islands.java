class Solution {
   
    public int closedIsland(int[][] grid) {
        
        //since we have to check whether a cell is surrounded by 1s or not, we will do dfs on 0s 
        //observation is : 0s of boundary cells will not be included in the answer
        
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        
        //dfs on all 0s 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0 && !visited[i][j])
                    if(dfs(i, j, grid, visited))
                        count++;
            }
        }  
        return count;
    }
    
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    private boolean dfs(int i, int j, int[][] grid, boolean[][] visited){
        //out of bounds that means current cell is not a closed island hence return false
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }
        
        if(grid[i][j]==1 || visited[i][j]){ //dont do dfs on 1 cells
            return true;
        }
        
        //mark it as visited
        visited[i][j] = true;
        boolean isClosed = true;
        
        //check its neighbours and if those are 0 go and do more dfs
        for(int[] dir : dirs){   
            
            int x1 = i + dir[0];
            int y1 = j + dir[1];
            
            if(!dfs(x1, y1, grid, visited))
                isClosed = false;
        }
        
        return isClosed;
    }
}