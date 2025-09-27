class Solution {
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
    }

    private boolean isAllStars(String s2, int i){
        for(int j=0; j<=i; j++){
            if(s2.charAt(j) != '*'){
                return false;
            }
        }
        return true;
    }
}