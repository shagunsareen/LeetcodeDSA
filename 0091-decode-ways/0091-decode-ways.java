class Solution {

    //Recursion with memoization
    /*Map<Integer, Integer> memo = new HashMap<>();
    
    public int numDecodings(String s) {
        return decode(0, s);
    }

    private int decode(int index, String s){
        if(memo.containsKey(index)){
            return memo.get(index);
        }

        if(index == s.length()){
            return 1;
        }

        if(s.charAt(index) == '0'){
            return 0; //cant decode string starting with 0
        }

        if (index == s.length() - 1) {
            return 1;
        }

        int ans = decode(index + 1, s);

        if(Integer.parseInt(s.substring(index, index + 2)) <= 26){
            ans += decode(index + 2, s);
        }

        //save for memoization that at this index what all 
        memo.put(index, ans);

        return ans;
    } 

    //Iterative Approach 
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; //we store ways possible to decode for substring from 0 to curr index

        //ways to decode string of size 1
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i=2; i<dp.length; i++){
            //check for single digit decode 
             if(s.charAt(i-1) != '0'){
                 dp[i] = dp[i-1];
             }   

             //check if successful two digit decode is possible 
             int twoDigit = Integer.valueOf(s.substring(i-2, i));
             if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i-2];
             }
        }  
        return dp[s.length()];      
    }
    */

    //Space Optimised Iterative Approach 
    public int numDecodings(String s) {
        int n = s.length();
        
        int prev = 1;

        //ways to decode string of size 1
        int curr = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i=2; i<=s.length(); i++){
            int temp = 0;

            //check for single digit decode 
             if(s.charAt(i-1) != '0'){
                 temp = curr;
             }   

             //check if successful two digit decode is possible 
             int twoDigit = Integer.valueOf(s.substring(i-2, i));
             if(twoDigit >= 10 && twoDigit <= 26){
                temp += prev;
             }

            prev = curr;
            curr = temp;
        } 
         
        return curr;      
    }
}