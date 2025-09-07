class Solution {

    //memoization
    /*int[][] dp;
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        dp = new int[r][c];
        for(int[] row : dp){
             Arrays.fill(row, -1);
        }   
        return getMinSum(grid, r-1, c-1);
    }

    private int getMinSum(int[][] grid, int row, int col){
        int r = grid.length;
        int c = grid[0].length;

        //check if we reached destination
        if(row == 0 && col == 0){
            return grid[row][col];
        }

        //check if cordinates are valid
        if(row < 0 || col < 0 ){
            return Integer.MAX_VALUE;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if(row > 0){
            up = grid[row][col] + getMinSum(grid, row-1, col);
        }
        
        if(col > 0){
            left = grid[row][col] + getMinSum(grid, row, col-1);
        }

        dp[row][col] = Math.min(up, left);
        return dp[row][col];
    }

    //TABULATION
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c]; //this dp arr stores min path sum till r and c index so for first row it would be same as grid 

        for(int row = 0; row < r; row++){
            for(int col = 0; col < c; col++){
                if(row == 0 && col == 0){
                    dp[row][col] = grid[row][col];
                }else{

                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if(row > 0){
                        up = grid[row][col] + dp[row-1][col];
                    }
                    
                    if(col > 0){
                        left = grid[row][col] + dp[row][col-1];
                    }

                    dp[row][col] = Math.min(up, left);
                }
            }
        }

        return dp[r-1][c-1];
    } */

    //space optimisation
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] prev = new int[c];

        for(int row = 0; row < r; row++){
            
            int[] curr = new int[c];

            for(int col = 0; col < c; col++){
                if(row == 0 && col == 0){
                    curr[col] = grid[row][col];
                }else{

                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if(row > 0){
                        up = grid[row][col] + prev[col];
                    }
                    
                    if(col > 0){
                        left = grid[row][col] + curr[col-1];
                    }

                    curr[col] = Math.min(up, left);
                }
            }

            prev = curr;
        }
        return prev[c-1];
    }
}