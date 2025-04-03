class Solution {
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
}