class Solution {

    //Tabulation
    public int longestPalindromeSubseq(String s) {   
        String reverseS = new StringBuilder(s).reverse().toString();
        return checkLongestPalindromeSubseq(s, reverseS);
        //if a subsequence is in s1 and is in its reverse string also then that is common subsequence but that will automatically be palindorme as it has same characters in reverse string 
    }

    /*private int checkLongestPalindromeSubseq(String s1, String s2){
        int len1 = s1.length();
        int len2 = s1.length();

        int[][] dp = new int[len1+1][len2+1]; //we shift 1 index in tabulation 

        //for 0 length string there wont be any common stringhence fill it with 0
        for(int row = 0; row <= len1; row++)
        {
            dp[row][0] = 0;
        }

        for(int col = 0; col <= len2; col++){
            dp[0][col] = 0;
        }

        for(int row = 1; row <= len1; row++){
            for(int col = 1; col <= len2; col++){
                if(s1.charAt(row - 1) == s2.charAt(col - 1)){
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                }else{
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                }
            }
        }

        return dp[len1][len2];
    }*/

    private int checkLongestPalindromeSubseq(String s1, String s2){
        int len1 = s1.length();
        int len2 = s1.length();

        int[] dp = new int[len2+1]; //we shift 1 index in tabulation 

        for(int col = 0; col <= len2; col++){
            dp[col] = 0;
        }

        for(int row = 1; row <= len1; row++){
            int[] curr = new int[len2+1];

            for(int col = 1; col <= len2; col++){
                if(s1.charAt(row - 1) == s2.charAt(col - 1)){
                    curr[col] = 1 + dp[col - 1];
                }else{
                    curr[col] = Math.max(curr[col - 1], dp[col]);
                }
            }
            dp = curr;
        }
        return dp[len2];
    }
}