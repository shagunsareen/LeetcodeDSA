class Solution {

    /* 
    //Memoization
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new int[n][m];

        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }

        return memoization(text1, text2, n-1, m-1, dp);
    }

    //max length of longest common subsequence 
    private int memoization(String text1, String text2, int index1, int index2, int[][] dp){
        //base case 
        if(index1 < 0 || index2 < 0){
            return 0;
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(text1.charAt(index1) == text2.charAt(index2)){ 
            return dp[index1][index2] = 1 + memoization(text1, text2, index1-1, index2-1, dp);
        }else{
            return dp[index1][index2] = Math.max(memoization(text1, text2, index1, index2-1, dp), 
                                memoization(text1, text2, index1-1, index2, dp));
        }  
    }

    //Tabulation
    //store all chars after shifting one index so that base case can be index1 == 0 as we need to go from bottom up
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        //fill first row and col to 0 as for empty string we cant have any max length
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

        
        for(int k=1; k<=n; k++) 
        {
            for(int j=1; j<=m; j++){ 
                if(text1.charAt(k-1) == text2.charAt(j-1)){ 
                     dp[k][j] = 1 + dp[k-1][j-1];
                }else{
                    dp[k][j] = Math.max(dp[k][j-1], dp[k-1][j]);
                }
            }
        }

        return dp[n][m];
    }*/

    //Space optimization
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m+1];

        for(int j=0; j<=m; j++){
            prev[j] = 0;
        }
            
        for(int k=1; k<=n; k++) 
        {     
            int[] curr = new int[m+1];
            for(int j=1; j<=m; j++){ 
                if(text1.charAt(k-1) == text2.charAt(j-1)){ 
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}