class Solution {

    //memoization
    /*int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] row : dp){
             Arrays.fill(row, -1);
        }
        return uniquePathWays(m , n , m-1, n-1); //start from (m-1, n-1) to (0,0)
    }

    private int uniquePathWays(int m , int n, int row, int col){
        if(row == 0 && col == 0){ 
            return 1;
        }

        if(row < 0 || col < 0)
        {
            return 0;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int up = uniquePathWays(m , n, row-1, col);

        int left = uniquePathWays(m , n, row, col - 1);

        dp[row][col] = up + left;
        
        return dp[row][col];
    }


    //Tabulation
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        Arrays.fill(dp[0], 1);

        for(int row = 1; row < m; row++){
            for(int col = 0; col < n; col++){
                
                if(row > 0){
                    dp[row][col] += dp[row-1][col];
                }
                
                if(col > 0){
                    dp[row][col] += dp[row][col-1];
                }
            }
        }
        return dp[m-1][n-1];
    }*/

    //Space optimisation
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];      
        
        Arrays.fill(prev, 1);

        for(int row = 1; row < m; row++){
            
            int[] curr = new int[n];

            for(int col = 0; col < n; col++){
                
                if(row > 0){
                    curr[col] += prev[col];
                }
                
                if(col > 0){
                    curr[col] += curr[col-1];
                }
            }

            prev = curr;
        }
        return prev[n-1];
    }
}