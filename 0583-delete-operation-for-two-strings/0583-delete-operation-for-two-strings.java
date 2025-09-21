class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        return n1 + n2 - 2 * getLongestCommonSubsequenceOptimised(word1, word2, n1, n2);
    }

    //tabulation
    private int getLongestCommonSubsequence(String word1, String word2, int n1, int n2){
        
        int[][] dp = new int[n1 + 1][n2 + 1];

        //fill 0 length string as 0 since it cant have subsequence
        for(int row = 0; row <= n1; row++){
            dp[row][0] = 0;
        }

        for(int col = 0; col <= n2; col++){
            dp[0][col] = 0;
        }

        for(int row = 1; row <= n1; row++){
            for(int col = 1; col <= n2; col++){
                if(word1.charAt(row - 1) == word2.charAt(col - 1)){
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                }else{
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        return dp[n1][n2];
    }  

    //space optimisation
    private int getLongestCommonSubsequenceOptimised(String word1, String word2, int n1, int n2){
        
        int[] prev = new int[n2 + 1];
        for(int col = 0; col <= n2; col++){
            prev[col] = 0;
        }

        for(int row = 1; row <= n1; row++){

            int[] curr = new int[n2+1];

            for(int col = 1; col <= n2; col++){
                if(word1.charAt(row - 1) == word2.charAt(col - 1)){
                    curr[col] = 1 + prev[col - 1];
                }else{
                    curr[col] = Math.max(prev[col], curr[col - 1]);
                }
            }
            prev = curr;
        }
        return prev[n2];
    }   
}