class Solution {
    public int maxProfit(int[] prices) {
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
    }
}