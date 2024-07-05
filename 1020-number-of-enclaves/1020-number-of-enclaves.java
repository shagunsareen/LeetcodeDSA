class Solution {
    public int numEnclaves(int[][] grid) {    
        //we can go for dfs for all 1s and see if they reach boundary cell or not 
        //but we have an alternative approach where we start from boundary cell 1's and 
        //do dfs and see if they can reach every other 1 cell The ones which are left as 1 are not possible to be           reached from boundary and vice versa.
        
        //Step1 : Find boundary cell 1 and apply dfs 
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){       
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    if(grid[i][j]==1){
                         dfs(i, j, grid);
                    }    
                }
            }       
        }
        
        //Step2 : count 1s left in the grid
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){ 
                if(grid[i][j]==1)
                    count++;
            }
        }   
        return count;
    }
     
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    private void dfs(int i, int j, int[][] grid){ 
         //System.out.println(" Cell - i: "+i+", j : "+j);
        
        //mark the current cell as visited
        grid[i][j] = 2;
        
        //check in all 4 directions
        for(int[] dir : dirs){
            
            int x1 = i + dir[0];
            int y1 = j + dir[1];
            
             //check if the cell is valid and not visited then do dfs 
            if(isValid(x1, y1, grid.length, grid[0].length) && grid[x1][y1]==1){
                dfs(x1, y1, grid);
            }
        } 
    }
    
    private boolean isValid(int i, int j, int rows, int cols){  
        if(i<0 || i>=rows || j<0 || j>=cols){
            return false;
        }
        return true;
    }
}