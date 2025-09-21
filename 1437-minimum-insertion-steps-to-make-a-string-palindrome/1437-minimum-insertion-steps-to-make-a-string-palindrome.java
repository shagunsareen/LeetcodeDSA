class Solution {
    //first we preserve the actual lenght of the palindromic string so that we should know how many additional characters we need to make entire string palindrome
    public int minInsertions(String s) {
        int n = s.length();
        //insertions required to make a string a palindrome = n - length of longest palindromic subsequence
        return n  - getLongestPalindromicSubsequence(s, new StringBuilder(s).reverse().toString());
    }

    //Tabulation
    private int getLongestPalindromicSubsequence(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        //fill row 0 and col 0 as 0 
        for(int row = 0; row <= len1 ; row++){
            dp[row][0] = 0;
        }

        for(int col = 0; col <= len2 ; col++){
            dp[0][col] = 0; 
        }

        //fill other indexes 
        for(int row = 1; row <= len1 ; row++){
             for(int col = 1; col <= len2 ; col++){ 
                 if(s1.charAt(row - 1) == s2.charAt(col - 1)){
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                 }else{
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                 }
             }
        }

        return dp[len1][len2];
    }
}