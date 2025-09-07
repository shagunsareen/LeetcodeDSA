class Solution {

    //Memoization
    /*int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1]; //at certain index all elements from 0 to ith index can give Target in how many coins
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int res = getMinCoin(n-1, coins, amount) ;
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int getMinCoin(int index, int[] coins, int amount){
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

        int take = Integer.MAX_VALUE;

        if(coins[index] <= amount){
            int res = getMinCoin(index, coins, amount - coins[index]); 
            // since we can take same coin multiple times we dont decrement index
            if(res != Integer.MAX_VALUE)
            {
                take = 1 + res;
            }
        }

        int notTake = getMinCoin(index - 1, coins, amount);

        dp[index][amount] = Math.min(notTake, take);
        return dp[index][amount];
    }*/
    
    //Tabulation 
    /*int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1];

        //first row 
        for(int t=0; t<=amount; t++){               
            if(t % coins[0] == 0){
                dp[0][t] = t/coins[0];
            }else{
                dp[0][t] = Integer.MAX_VALUE;
            }
        }

        //fill rest of the table 
        for(int index = 1; index <n; index++){
            for(int target = 0; target <= amount; target++){
                int taken = Integer.MAX_VALUE;

                if(coins[index] <= target){
                    int res = dp[index][target - coins[index]];
                    if(res != Integer.MAX_VALUE){
                        taken = 1 + res;
                    }
                }

                int notTaken = dp[index-1][target];

                dp[index][target] = Math.min(taken, notTaken);
            }
        }

        return dp[n-1][amount] == Integer.MAX_VALUE ? -1 : dp[n-1][amount];
    }*/

    //Space optimised 
    public int coinChange(int[] coins, int amount) {
        int n =coins.length;
        int[] prev = new int[amount + 1];
        

        //fill prev row so that we have prev for next all rows
        for(int t=0; t<=amount; t++){
            if(t % coins[0] == 0){
                prev[t] = t / coins[0];
            }else{
                prev[t] = Integer.MAX_VALUE;
            }
        }

        //for other indexes
        for(int index = 1; index < n; index++){

            int[] curr = new int[amount + 1];

            for(int target = 0; target <= amount; target++){
                
                int taken = Integer.MAX_VALUE;
                
                if(coins[index] <= target){
                    int res = curr[target - coins[index]];
                    if(res != Integer.MAX_VALUE){
                        taken = 1 + res;
                    }
                }

                int notTaken = prev[target];

                curr[target] = Math.min(taken, notTaken);
            }   
            prev = curr;
        }
        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];
    }
}