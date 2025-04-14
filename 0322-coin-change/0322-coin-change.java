class Solution {

    //Memoization
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int result = getMinCoins(coins, amount, n - 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int getMinCoins(int[] coins, int amount, int index){
        //base case 
        if(amount == 0){
            return 0;
        }

        if(index == 0){
            if(amount % coins[index] == 0){
                return amount / coins[index];
            }
            return Integer.MAX_VALUE;
        }

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        int taken = Integer.MAX_VALUE;

        if(coins[index] <= amount){
            int res = getMinCoins(coins, amount - coins[index], index);
            if(res != Integer.MAX_VALUE){
                taken = 1 + res;
            }       
        }

        int notTaken = getMinCoins(coins, amount, index-1);

        dp[index][amount] = Math.min(taken, notTaken);
        return dp[index][amount];
    }
}