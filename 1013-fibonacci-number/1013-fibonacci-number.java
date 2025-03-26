class Solution {

    /*
        //TC : O(N), SC:O(N)
        //Memoization - Top Down approach as it involves recursion

    int[] dp;

    public int fib(int n) {
        dp = new int[n+1];  
        Arrays.fill(dp, -1);  
        return getFibonnaci(n);
    }

    private int getFibonnaci(int num){
        //when we calculate ans for one num we should store it in array so that further if the same function is called that can be used then
        if(num <= 1){
            return num; // n == 0 then 0 , n == 1 then 1
        }

        if(dp[num] == -1){ //if its NOT precalculated then calculate the value 
            dp[num] = getFibonnaci(num-1) + getFibonnaci(num-2); //store the value calculated
        }

        return dp[num];
    }*/

    //Approach 2 - Tabulation - Bottom up approach i.e. we start from base case and we move upward 
    int[] dp;

    public int fib(int n) {
        dp = new int[n+1];  

        dp[0] = 0;

        if(n > 0){
            dp[1] = 1;
        }
        
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }



}