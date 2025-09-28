class Solution {
    
    /*public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3]; //index - buy/notBuy 

        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                 Arrays.fill(dp[i][j], -1);
            }
        }
        return memoiz(prices, dp, 0, 0, 2);
    }

    //at any point we can store that if we are at a certain index at this point can i buy this stock or not since i can buy only if previous one is sold , this info can be stored in dp array
    private int memoiz(int[] prices, int[][][] dp, int index, int buy, int cap){
        //base case 
        if(index == prices.length || cap == 0){
            return 0; //no element left
        }

        if(dp[index][buy][cap] != -1){
            return dp[index][buy][cap];
        }

        if(buy == 0){ //we can buy the stock - invest money and go to next index
              int buyStock = -prices[index] + memoiz(prices, dp, index + 1, 1, cap);
              int doNothing = memoiz(prices, dp, index + 1, 0, cap);

              dp[index][buy][cap] = Math.max(buyStock , doNothing);
        }else if(buy == 1){ //sell case 
            int sellStock = prices[index] + memoiz(prices, dp, index + 1, 0, cap-1);
            int doNothing = memoiz(prices, dp, index + 1, 1, cap);

            dp[index][buy][cap] = Math.max(sellStock , doNothing);
        }

        return dp[index][buy][cap];
    }*/

    //Tabulation
    /*public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        //if cap = 0 index and buy can be anything
        /*for(int index = 0; index < n; index++){
            for(int buy = 0; buy <= 1; buy++){
                dp[index][buy][0] = 0;
            }
        }

        for(int buy = 0; buy <= 1; buy++){
            for(int cap = 0; buy <= 2; cap++){
                dp[n][buy][cap] = 0;
            }
        }

        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                 for(int cap = 1; cap <= 2; cap++){ //cap starts from 1 because for 0 its always going to be 0
                    if(buy == 0){ //we can buy the stock - invest money and go to next index
                        int buyStock = -prices[index] + dp[index + 1][1][cap];
                        int doNothing = dp[index + 1][0][cap];

                        dp[index][buy][cap] = Math.max(buyStock , doNothing);
                    }else if(buy == 1){ //sell case 
                        int sellStock = prices[index] + dp[index + 1][0][cap-1];
                        int doNothing = dp[index + 1][1][cap];

                        dp[index][buy][cap] = Math.max(sellStock , doNothing);
                    }
                }
            }
        }
        return dp[0][0][2];
    }*/


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];

        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 0){ //we can buy the stock - invest money and go to next index
                        int buyStock = -prices[index] + prev[1][cap];
                        int doNothing = prev[0][cap];

                        curr[buy][cap] = Math.max(buyStock , doNothing);
                    }else if(buy == 1){ //sell case 
                        int sellStock = prices[index] + prev[0][cap-1];
                        int doNothing = prev[1][cap];

                        curr[buy][cap] = Math.max(sellStock , doNothing);
                    }
                }
                prev = curr;
            }
        }
        return prev[0][2];
    }
}