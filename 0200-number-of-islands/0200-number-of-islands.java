class Solution {
    
    private int n;
    private int m;
    
    public int numIslands(char[][] grid){
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        //select the starting point and see how many starting point we can have that many no. of distinct islands 
        //because that would mean 1 island is not covering every cell and has some unvisited cells still
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){ 
                    //take this as the starting point 
                    count++; //this is one island 
                    dfs(grid, i, j, row, col);
            }
         }
       }
      return count;
    }
    
    private void dfs(char[][] A, int i, int j, int n , int m){
        //base case - if we have reached water or out of bounds then return from this path
        if(i < 0 || j < 0 || i>=n || j>=m || A[i][j] == '0'){
            return; //current connected island is over
        }
        
        //now mark the current cell as visited 
        A[i][j] = '0';
        
        //go in all directions and mark them as visited so that we should not count them again in same island 
        dfs(A, i+1, j, n, m);
        dfs(A, i-1, j, n, m);
        dfs(A, i, j+1, n, m);
        dfs(A, i, j-1, n, m);
    }
    
}   
    