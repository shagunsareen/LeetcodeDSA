class Solution {

    //Memoization
    /*public int minDistance(String word1, String word2) {
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
    }*/

    //Tabulation - move 1 index forward
    /*public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int j = 0; j < m + 1 ; j++){
            dp[0][j] = j;
        }

        for(int i = 0; i < n + 1; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; 
                }else{
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1]; 
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }*/

    //Space optimisation
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m+1];
        
        for(int j = 0; j < m + 1 ; j++){
            prev[j] = j;
        }

        for(int i = 1; i <= n; i++){    
            int[] curr = new int[m+1];
            curr[0] = i; //as per base case in previous code
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1]; 
                }else{
                    int insert = curr[j-1];
                    int delete = prev[j];
                    int replace = prev[j-1]; 
                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }

        return prev[m];
    }

}