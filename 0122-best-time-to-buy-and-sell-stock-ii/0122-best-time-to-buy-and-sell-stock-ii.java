class Solution {

    /*
    //Memoization
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2]; //index - buy/notBuy 

        for(int[] row : dp){
             Arrays.fill(row, -1);
        }

        return memoiz(prices, dp, 0, 0);
    }

    //at any point we can store that if we are at a certain index at this point can i buy this stock or not since i can buy only if previous one is sold , this info can be stored in dp array
    private int memoiz(int[] prices, int[][] dp, int index, int buy){
        //base case 
        if(index == prices.length){
            return 0; //no element left
        }

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }

        if(buy == 0){ //we can buy the stock - invest money and go to next index
              int buyStock = -prices[index] + memoiz(prices, dp, index + 1, 1);
              int doNothing = memoiz(prices, dp, index + 1, 0);

              dp[index][buy] = Math.max(buyStock , doNothing);
        }else if(buy == 1){ //sell case 
            int sellStock = prices[index] + memoiz(prices, dp, index + 1, 0);
            int doNothing = memoiz(prices, dp, index + 1, 1);

            dp[index][buy] = Math.max(sellStock , doNothing);
        }

        return dp[index][buy];
    }*/

    //Tabulation - will go from n-1 to 0 as memoization went from o to n-1 (Bottom up approach)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        //base case if for index == n when we are not left with any more days to buy or sell
        dp[n][0] = 0;
        dp[n][1] = 0; 

        for(int index = n-1; index>=0; index--){
            for(int buy = 0; buy <=1; buy++){
                if(buy == 0){ //we can buy the stock - invest money and go to next index
                    int buyStock = -prices[index] + dp[index + 1][1];
                    int doNothing = dp[index + 1][0];

                    dp[index][buy] = Math.max(buyStock , doNothing);
                }else if(buy == 1){ //sell case 
                    int sellStock = prices[index] + dp[index + 1][0];
                    int doNothing = dp[index + 1][1];

                    dp[index][buy] = Math.max(sellStock , doNothing);
                }
            }
        }

        return dp[0][0];
    }
}