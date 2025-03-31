class Solution {
    /*
    Approach - Recursion - TLE as TC is 2^(m+n)
    public int uniquePaths(int m, int n) {
       return getUniquePaths(m, n, 0, 0);
    }

    private int getUniquePaths(int m, int n, int row, int col){
        //out of bound indexes
        if(row >= m || col >= n){
            return 0;
        }

        //base case - reached last cell
        if(row == m-1 && col == n-1){
            return 1;
        }

        int bottom = getUniquePaths(m, n, row+1, col);
        int right = getUniquePaths(m, n, row, col + 1);

        return bottom + right;
    }
    */

    //Approach 2 - Memoization - TC : O(mxn) , total of m × n unique states (each cell in the grid is a state) & each state is being computed once 
    /*int[][] dp;
    public int uniquePaths(int m, int n) {
       dp = new int[m][n]; 

       for(int[] row : dp){
         Arrays.fill(row, -1);
       }
       
       return getUniquePaths(m, n, 0, 0);
    }

    private int getUniquePaths(int m, int n, int row, int col){
        //out of bound indexes
        if(row >= m || col >= n){
            return 0;
        }

        //base case - reached last cell
        if(row == m-1 && col == n-1){
            return 1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int bottom = getUniquePaths(m, n, row+1, col);
        int right = getUniquePaths(m, n, row, col + 1);

        dp[row][col] = bottom + right;
        return dp[row][col];
    }*/

    //Approach 3 : Tabulation 
    int[][] dp;
    public int uniquePaths(int m, int n) {
       dp = new int[m][n]; 

       for(int[] row : dp){
         Arrays.fill(row, -1);
       }
       
       for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){

            //if we have reached last cell
            if(i == 0 && j == 0){
                dp[i][j] = 1;
                continue;
            }

            //either we move down or we move right 
            int up = 0;
            int left = 0;

            if(j > 0){
                up = dp[i][j-1];
            }
            
            if(i > 0){
                left = dp[i-1][j];
            }
            
            dp[i][j] = up + left;
        }
       }

       return dp[m-1][n-1]; //return total number of ways to reach last cell
    }
}