class Solution {

    //Memoization - since we do recursion from 1 point hence starting from top instead of bottom
    /*int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return getPathSum(triangle, 0, 0, n);
    }

    private int getPathSum(List<List<Integer>> triangle, int row, int col, int n){
        //base case - reached last row
        if(row == n-1){
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != -1)
        {
            return dp[row][col];
        }

        int down = triangle.get(row).get(col) + getPathSum(triangle, row + 1, col, n);

        int diagonal = triangle.get(row).get(col) + getPathSum(triangle, row + 1, col + 1, n);

        dp[row][col] = Math.min(down, diagonal);
        return dp[row][col];
    }

    //Tabulation
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        //fill dp table from below
        for(int col = 0; col<n; col++){
            dp[n-1][col] = triangle.get(n-1).get(col);
        }

        for(int row = n-2; row >= 0; row--){
            for(int col = row; col >= 0; col--){
               int down = triangle.get(row).get(col) + dp[row + 1][col];
               int diagonal = triangle.get(row).get(col) + dp[row + 1][col + 1];

               dp[row][col] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    } */

    //Space optimisation
    //Tabulation
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] next = new int[n];

        //fill dp table from below
        for(int col = 0; col<n; col++){
            next[col] = triangle.get(n-1).get(col);
        }

        for(int row = n-2; row >= 0; row--){
            int[] curr = new int[n];

            for(int col = row; col >= 0; col--){
               int down = triangle.get(row).get(col) + next[col];
               int diagonal = triangle.get(row).get(col) + next[col + 1];

               curr[col] = Math.min(down, diagonal);
            }

            next = curr;
        }
        return next[0];
    }

}