class Solution {

    /*
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return memoization(dp, s, p, n-1, m-1) == 1;
    }
    

    //else part 1. s1 has * and we replace it with nothing and act as if no * was there so we move to i-1 2. replace * with single character at j and still stand at same place so that we can match it with more characters so we move j-1
    private int memoization(int[][] dp, String s1, String s2, int i, int j){
        //base case 
        if(i < 0 && j < 0){
            return 1; //both exhausted and gets empty so match is present
        }

        if(j < 0 && i >= 0){
            return 0; //s2 which has pattern is exhausted
        }
        if(i < 0 && j >= 0){ //pattern is pending and other string is exhausted
            return isAllStars(s2, j) ? 1 : 0; //since if s1 has all starts it can be compared with all empty string s2 then it would be 1 
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?'){
            return dp[i][j] = memoization(dp, s1, s2, i-1, j-1);
        }else {
            if(s2.charAt(j) == '*'){
                return dp[i][j] = (memoization(dp, s1, s2, i-1, j) == 1 || 
                            memoization(dp, s1, s2, i, j-1)  == 1) ? 1 : 0;
            }else{ //characters dont match and s1[i] is not '*'
                return 0;
            }
        }
    }*/

    private boolean isAllStars(String s2, int i){
        for(int j=0; j<=i; j++){
            if(s2.charAt(j) != '*'){
                return false;
            }
        }
        return true;
    }


    //Tabulation
    /*public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=1; i<=n; i++){
            dp[i][0] = false;  // non-empty string can't match empty pattern
        }

        for(int j=1; j<=m; j++){
            dp[0][j] = isAllStars(p, j-1); // empty string matches only if pattern has all *
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                         dp[i][j] = dp[i-1][j-1];
                    }else {
                        if(p.charAt(j-1) == '*'){
                             dp[i][j] = dp[i-1][j] || dp[i][j-1];
                        }else{ //characters dont match and s1[i] is not '*'
                            dp[i][j] = false;
                        }
                    }
            }
        }
        return dp[n][m];
    }*/

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[] prev = new boolean[m+1];
        boolean[] curr = new boolean[m+1];

        prev[0] = true; // empty string vs empty pattern

        for(int j=1; j<=m; j++){
            prev[j] = isAllStars(p, j-1);  // empty string matches only if pattern has all *
        }

        for(int i=1; i<=n; i++){
            curr[0] = false; //taking into consideration base case where j = 0
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                        curr[j] = prev[j-1];
                }else {
                    if(p.charAt(j-1) == '*'){
                            curr[j] = prev[j] || curr[j-1];
                    }else{ //characters dont match and s1[i] is not '*'
                        curr[j] = false;
                    }
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}