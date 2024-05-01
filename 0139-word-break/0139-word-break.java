class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return solve(0, 0, s, new HashSet<>(wordDict), dp);
    }

    private boolean solve(int start, int end, String str, Set<String> dict, int[][] dp){
       //base case 
       if(dp[start][end] != -1){
           return dp[start][end] == 1 ? true : false;
       }
       //base case 
       if(end == str.length() - 1){
           if(dict.contains(str.substring(start, end+1))){
               return true;
           }
           return false;
       }
        //if this substring is present then we will move to next string
       if(dict.contains(str.substring(start, end+1))){ 
           if(solve(end + 1, end + 1, str, dict, dp)){
               dp[start][end] = 1; // this entire string is as expected
               return true;
           }
       }

    //if curr substring is not present then include next index as well and check same
       boolean ans = solve(start, end+1, str, dict, dp); 
       dp[start][end] = ans ? 1 : 0;
       return ans;
    }
}