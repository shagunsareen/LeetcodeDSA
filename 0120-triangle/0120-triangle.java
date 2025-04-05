class Solution {

    //Approach : Memoization
    int[][] dp;
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
    }
}