class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    int max = dfs(i, j, grid, 0);
                    maxArea = Math.max(maxArea, max);
                }
            }
        }
        
        return maxArea;
    }
    
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    private int dfs(int i, int j, int[][] grid, int area){
        //false case
        if(!isValid(i, j, grid.length, grid[0].length) || grid[i][j]!=1)
            return 0;
        
        //mark it as visited 
        grid[i][j] = 2;
        
        area = 1;
        
        //go and check in all the directions maxArea
        for(int[] dir : dirs){
            
            int x1 = i + dir[0];
            int y1 = j + dir[1];

            area += dfs(x1, y1, grid, area);
        }
        
        return area;
    }
    
    private boolean isValid(int x1, int y1, int rows, int cols){     
       return x1 >= 0 && y1>=0 && x1 < rows && y1 < cols;
    }
}