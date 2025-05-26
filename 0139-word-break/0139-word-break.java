class Solution {

    //Backtracking - TLE with TC O(2^n) as if l is in set i will call wb(eetcode), if le is present i will call wb(etcode) ans so on...so i have 2 choices at each index
    /*public boolean wordBreak(String s, List<String> wordDict) {
        return canWordBreak(s, new HashSet<>(wordDict), 0);
    }

    private boolean canWordBreak(String s, Set<String> dict, int start){
        //base case 
        if(start == s.length()){
            return true;
        }

        for(int end = start + 1; end <= s.length(); end++){
            if(dict.contains(s.substring(start, end))){ //check if l is present then check for rest of the string else create le , lee, leet and repeat same process
                if(canWordBreak(s, dict, end))
                    return true;
            }
        }

        return false; //all substrings are checked with this start point and nothing is present in set then return false*/

        //approach 2 - dp with memoization
        public boolean wordBreak(String s, List<String> wordDict) {
            return canWordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]); // here memo stores that substring starting at 'i'th index can be segmented into dict words
        }

        private boolean canWordBreak(String s, Set<String> dict, int start, Boolean[] memo){
            if(start == s.length()){
                return true;
            }

            if(memo[start] != null){
                return memo[start]; //value is already calculated dont calculate again
            }

            for(int end = start + 1; end <= s.length(); end++){
                if(dict.contains(s.substring(start, end))){ //check if l is present then check for rest of the string else create le , lee, leet and repeat same process
                    if(canWordBreak(s, dict, end, memo)){
                         memo[start] = true;
                         return true;
                    }    
                }
            }

            memo[start] = false; // its not possible from this index 
            return false;
        }
}