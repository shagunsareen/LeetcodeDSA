class Solution {
    
    
    /* Approach 1 : Memoization, TC- TLE
    
    //you can go from start row to end row or end row to start row 
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int minSum = Integer.MAX_VALUE;

        //since we can reach from first row cells to last row cells so we can have multiple falling path sums we need to get minimum of all this sum
        for(int col = 0; col < cols; col++){
            minSum = Math.min(minSum, getMinSum(matrix, rows-1, col));
        }

        return minSum;
    }

    private int getMinSum(int[][] matrix, int row, int col){
        //base case - generally destination cell
        if(row == 0){
            return matrix[0][col];
        }

        if(row < 0  || col < 0 || col >= matrix[0].length){
            return Integer.MAX_VALUE;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int upSum = Integer.MAX_VALUE;
        int leftDiagSum = Integer.MAX_VALUE;
        int rightDiagSum = Integer.MAX_VALUE;

        if(row > 0){
            upSum = matrix[row][col] + getMinSum(matrix, row-1, col);
        }
        if(row > 0 && col > 0){
            leftDiagSum = matrix[row][col] + getMinSum(matrix, row-1, col-1);
        }
        if(row > 0 && col < matrix[0].length - 1){
             rightDiagSum = matrix[row][col] + getMinSum(matrix, row-1, col+1);
        }
        
        dp[row][col] = Math.min(upSum, Math.min(leftDiagSum, rightDiagSum));
        return dp[row][col];
    }
    */

    //Approach 2 : Tabulation
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        //fill the first row of dp since we go from 0 to last row 
        for(int col = 0; col < cols; col++){
            dp[0][col] = matrix[0][col];
        }

        //fill all other dp cells
        for(int row = 1; row < rows; row++){
            for(int col = 0; col < cols; col++){
                
                int upSum = Integer.MAX_VALUE;
                int leftDiagSum = Integer.MAX_VALUE;
                int rightDiagSum = Integer.MAX_VALUE;

                if(row > 0 ){
                    upSum = matrix[row][col] + dp[row-1][col];
                }
                if(row > 0 && col > 0){
                    leftDiagSum = matrix[row][col] + dp[row-1][col-1];
                }
                if(row > 0 && col < cols - 1){
                    rightDiagSum = matrix[row][col] + dp[row-1][col+1];
                }
                
                dp[row][col] = Math.min(upSum, Math.min(leftDiagSum, rightDiagSum));
            }
        }

        int minSum = Integer.MAX_VALUE;
        //iterate over last row and get min sum
        for(int col = 0; col < cols; col++){
            minSum = Math.min(minSum, dp[rows-1][col]);
        }

        return minSum;
    }
}