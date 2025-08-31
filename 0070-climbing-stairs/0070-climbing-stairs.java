class Solution {

    //Recursion  - TC : O(2^n), SC : O(n)

    /*public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    private int climbStairs(int index, int n){
        if(index > n){
            return 0;
        }

        if(index == n){
            return 1;
        }

        return climbStairs(index + 1, n) + climbStairs(index + 2, n); 
        //at every point we have 2 paths to take so whatever is current state we take both paths one by one and see if we reach destination
    }*/

    //Memoization - keep array to store pre computed solutions (Top Down) is with recursion, TC:O(n) SC:O(n)
    /*public int climbStairs(int n) {
        int[] memo = new int[n+1]; //since we need result for 3 so if we get climbStairs(3) and if its already calculated before then we can directly return that value so we take n+1
        return climbStairs(0, n, memo);
    }

    private int climbStairs(int index, int n, int[] memo){
        if(index > n){
            return 0;
        }

        if(index == n){
            return 1;
        }

        memo[index] = climbStairs(index + 1, n, memo) + climbStairs(index + 2, n, memo);
        return memo[index];
    }*/

    //Tabulation - Bottom up - this is iterative , TC:O(n) SC:O(n)
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}