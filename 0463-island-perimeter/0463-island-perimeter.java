class Solution {
    
    //Approach 1 : TC: O(row*col), SC: O(1) 
    /*public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
    
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    num += 4; //consider it as a best case with no neighbours
                    
                    //check if it has up neighbour 
                    if(i > 0 && grid[i-1][j]==1){
                        num -= 2;
                    }
                    
                    //check if it has left neighbour
                    if(j>0 && grid[i][j-1]==1){
                        num -=2;
                    }
                }
            }
        }
        return num;
    }*/
    
    //Approach 2 : DFS
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
    
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1){
                    //apply dfs
                    return dfs(grid, i, j);
                }
            }
        }
        
        return 0; //no islands
    }
    
    private int dfs(int[][] A, int i, int j){
        int rows = A.length;
        int cols = A[0].length;
        
        //if it's out of bound or is water then count it since it will be considered as boundary
        if(i<0 || i>=rows || j<0 || j>=cols || A[i][j] == 0){
            return 1;
        }
        
        if(A[i][j] == -1){
            return 0; //already visited cell
        }
        
        A[i][j] = -1; //mark it visited if it was not already marked
        
        int perimeter = 0;
        perimeter +=dfs(A, i-1, j); //UP
        perimeter +=dfs(A, i, j-1); //DOWN
        perimeter +=dfs(A, i, j+1); //RIGHT
        perimeter +=dfs(A, i+1, j); //DOWN
            
        return perimeter;
    }
}