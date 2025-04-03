class Solution {
    /*  
    Approach 1 : Memoization
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return getMinPathSum(grid, n-1, m-1);
    }

    private int getMinPathSum(int[][] grid, int row, int col){
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }

        if(row == 0 && col == 0){
            return grid[row][col];
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if(row > 0){
            up = grid[row][col] + getMinPathSum(grid, row-1, col);
        }

        if(col > 0){
            left = grid[row][col] + getMinPathSum(grid, row, col-1);
        }

         dp[row][col] = Math.min(up, left);

         return dp[row][col];    
    }
    */

    //Approach 2 : Tabulation
    /*int[][] dp;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];

        //now we need to calculate entire dp array from bottom to top meaning from top left to bottom right cell
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(i == 0 && j==0){
                    dp[i][j] = grid[i][j];
                }else{
                    int up = Integer.MAX_VALUE;;
                    int left = Integer.MAX_VALUE;;

                    if( i > 0){
                        up = grid[i][j] + dp[i-1][j];
                    }

                    if(j > 0){
                        left = grid[i][j] + dp[i][j-1];
                    }
                     dp[i][j] = Math.min(up, left);
                }               
            }
        }
        return dp[n-1][m-1];
    }*/

    //Approach 3 : Space optimisation
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];

        for(int i=0; i<n; i++){ 
            int[] temp = new int[m]; //this will have curr row values 
            for(int j=0; j<m; j++){
                
                if(i == 0 && j == 0){
                    temp[j] = grid[i][j]; 
                }else{
                    int up = grid[i][j];
                    int left = grid[i][j];

                    if(i > 0){
                        up += prev[j];
                    }else{
                        up = Integer.MAX_VALUE;
                    }
                    if(j > 0){
                        left += temp[j-1];
                    }else{
                        left = Integer.MAX_VALUE;
                    }

                    temp[j] = Math.min(up, left);
                }
            }
            prev = temp; // so that prev should have curr value as prev for next iteration
        }

        return prev[m-1];
    }
}