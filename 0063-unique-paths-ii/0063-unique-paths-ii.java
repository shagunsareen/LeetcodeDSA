class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        dp = new int[n][m];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return possiblePaths(obstacleGrid, 0, 0);
    }

    private int possiblePaths(int[][] obstacleGrid, int row, int col){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if(row >= 0 && col >= 0 && row <n && col <m && obstacleGrid[row][col] == 1){
            return 0;
        }

        if(row < 0 || col < 0 || row >n || col >m){
            return 0;
        }

        if(row == n-1  && col == m-1){ //reached last cell
            return 1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int down = 0;
        int right = 0;

        if(row < n-1){
            down = possiblePaths(obstacleGrid, row+1, col);
        }
        
        if(col < m-1){
            right = possiblePaths(obstacleGrid, row, col+1);
        }
        
        dp[row][col] = down + right;

        return dp[row][col];
    }
}