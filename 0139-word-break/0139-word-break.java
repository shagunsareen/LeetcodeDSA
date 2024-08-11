class Solution {
    /*public boolean wordBreak(String s, List<String> wordDict) {
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
    }*/
    
    Boolean[] present;
    public boolean wordBreak(String s, List<String> wordDict) {
        present = new Boolean[s.length()];
        return checkWordBreak(s, new HashSet<>(wordDict), 0);
    }
    
    private boolean checkWordBreak(String s, HashSet<String> set, int start){
        //till where will the index go
        if(start == s.length()){
            return true;
        }
        
        //check if string is already evaludated
        if(present[start]!=null){
            return present[start];
        }
        
        //we will deal with substrings so end will be start + 1 else we would have taken end = start 
        for(int end = start+1; end<=s.length() ; end++){
            String substr = s.substring(start, end);
            
            //check if this is present in the hashset or not 
            if(set.contains(substr)){
                //check rest of the word if that is also present then return true
                if(checkWordBreak(s, set, end)){
                    present[start] = true;
                    return true;
                }
            }
        }
        
        present[start] = false;
        return false;
    }
}