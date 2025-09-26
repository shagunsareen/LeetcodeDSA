class Solution {

    //Memoization
    int[][] dp;
    int prime = (int) (Math.pow(10, 9) + 7);
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n][m];

        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }

        return checkMemoizaiton(dp, n-1, m-1, s, t);
    }

    private int checkMemoizaiton(int[][] dp, int index1, int index2, String s, String t){
        if(index2 < 0){//we found all chars of t in s 
            return 1;
        }

        if(index1 < 0){ //we couldnt find all. chars of t in s 
            return 0;
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }

        if(s.charAt(index1) == t.charAt(index2)){
            int leave = checkMemoizaiton(dp, index1-1, index2-1, s, t) ;
            int stay = checkMemoizaiton(dp, index1-1, index2, s, t);
            dp[index1][index2] = ( leave + stay ); //it might happen that char in t can match with other characters in s to give us more subsequences 
        }else{
            dp[index1][index2] =  checkMemoizaiton(dp, index1-1, index2, s, t); //we need each character of t to find match in s so 
        }

        return dp[index1][index2];
    }
}