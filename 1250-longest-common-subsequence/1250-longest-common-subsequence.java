class Solution {

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
    
}