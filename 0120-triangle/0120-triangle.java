class Solution {

    //Approach : Memoization
    /*int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return getMinSum(triangle, 0, 0); 
    }

    //gives sum till the current co-ordinates
    private int getMinSum(List<List<Integer>> triangle, int row, int col){
        int n = triangle.size();

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        if(row == n-1){
            return triangle.get(row).get(col);
        }

        int curr = triangle.get(row).get(col);

        int down = curr + getMinSum(triangle, row + 1, col);
        int diag = curr + getMinSum(triangle, row + 1, col + 1);

        dp[row][col] = Math.min(down, diag);

        return dp[row][col];
    }*/

    //Approach 2 : Tabulation - Bottom up approach
    int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        for(int col = 0; col <n; col++){
            dp[n-1][col] = triangle.get(n-1).get(col);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down, diag);
            }
        }

        return dp[0][0];
    }
}