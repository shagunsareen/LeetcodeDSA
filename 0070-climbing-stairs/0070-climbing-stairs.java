class Solution {
    public int climbStairs(int n) {
        // either we can take one step or two steps that means if i want to get no of ways to climb at n then to reach n i can either come from n-1th step or n-2th step i.e. f(n) = f(n-1) + f(n-2)
        //It is similar to fibonacci series 

        //Tabulation - bottom up approach 

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        if(n <= 1){
            return dp[n];
        }

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
       
        return dp[n];  
    }
}