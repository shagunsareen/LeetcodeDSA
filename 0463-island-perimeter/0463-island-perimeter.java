class Solution {
    public int islandPerimeter(int[][] grid) {
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
    }
}