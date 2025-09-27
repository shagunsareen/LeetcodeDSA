class Solution {

    //Memoization
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return memoization(dp, word1, word2, n-1, m-1);
    }

    private int memoization(int[][] dp, String s1, String s2, int i, int j){
        //base case 
        if(i < 0){
            return j+1; //these many operations would be required 
        }

        if(j < 0){
            return i+1; //these many operations would be required
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //we compare characters of both strings and see what operations we can do 
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = memoization(dp, s1, s2, i-1, j-1); 
        }else{
            int insert = memoization(dp, s1, s2, i, j-1);
            int delete = memoization(dp, s1, s2, i-1, j);
            int replace = memoization(dp, s1, s2, i-1, j-1); 
            dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
        
        return dp[i][j];
    }
}