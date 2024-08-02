class Solution {
    
    int possiblePaths = 0;
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int startRow = -1;
        int startCol = -1;
        int countZeroCells = 0;
        
        //to traverse from start find 1 and to traverse all cells find count of cells to traverse 
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int current = grid[i][j];
                if(current == 1){
                    startRow = i;
                    startCol = j;
                }else if(current == 0){
                    countZeroCells++;
                }    
            }
        }  
        
        dfs(grid, countZeroCells+1, startRow, startCol); //counting starting position as well in the cell count
        return possiblePaths;
    }
    
    //to traverse the paths from start to end 
    private void dfs(int[][] grid, int cellsToWalk, int startRow, int startCol){  
        
        //check if the points are out of bounds
        if(startRow < 0 || startCol < 0 || startRow >= grid.length || startCol >= grid[0].length || grid[startRow][startCol] == -1)         {
            return;       
        }
        
        //when we reach end increment the count of possible paths only if you were able to traverse all the 0's
        if(grid[startRow][startCol]==2){
            if(cellsToWalk==0)
            {
                possiblePaths++;
            }
            return;
        }
        
        if(grid[startRow][startCol] == 0 || grid[startRow][startCol] == 1){
            grid[startRow][startCol] = -1; //mark the cell as visited 
            cellsToWalk--;

            int[][] dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};

            for(int[] dir : dirs){ //go in all the 4 directions and do the same
                int x1 = startRow + dir[0];
                int y1 = startCol + dir[1];       
                dfs(grid, cellsToWalk, x1, y1);
            }

            grid[startRow][startCol] = 0;  //mark the cell as not visited 
            cellsToWalk++; 
        } 
    }
}