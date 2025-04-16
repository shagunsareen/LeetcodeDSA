class Solution {
    
    /*int[][] dp;
    public int change(int amount, int[] coins) { 
        //in this dp array we will store using elements from 0 to ith index in how many ways target sum can be achieved 
        int n = coins.length;
        dp = new int[n][amount + 1];

        //base row 
        for(int col = 0; col <= amount; col++){
            if(col % coins[0] == 0){
                dp[0][col] = 1; // we are storing no. of ways target can be achieved not the no. of coins used
            }else{
                dp[0][col] = 0;
            }
        }

        //recursion
        for(int index = 1; index < n; index++){
            for(int target = 0; target <= amount; target++){
                int pick = 0;

                if(coins[index] <= target){
                    pick = dp[index][target - coins[index]]; //pick same element multiple times 
                }

                int notPick = dp[index-1][target]; //not pick so move to previous element

                dp[index][target] = pick + notPick; //ways to achieve target
            }
        }

        return dp[n-1][amount];
    }*/
    
     //Space optimised
     int[] prev;
     public int change(int amount, int[] coins) { 
        int n = coins.length;
        prev = new int[amount + 1];

        for(int col = 0; col <= amount; col++){
            if(col % coins[0] == 0){
                prev[col] = 1;
            }else{
                prev[col] = 0;
            }
        }

        for(int index = 1; index < n; index++){
            int[] curr = new int[amount + 1];

            for(int target = 0; target <= amount; target++){
                int pick = 0;

                if(coins[index] <= target){
                    pick = curr[target - coins[index]]; //pick same element multiple times 
                }

                int notPick = prev[target]; //not pick so move to previous element

                curr[target] = pick + notPick; //ways to achieve target
            }
            prev = curr;
        }

        return prev[amount];
     }
}