class Solution {

    //memoiz
    /*public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return memoiz(prices, dp, 0, 0);
    }

    private int memoiz(int[] prices, int[][] dp, int index, int buy){
        //base case 
        if(index >= prices.length){ //since we are jumping to index+2 so if we are at n-1 then we should handle condition with >=
            return 0;
        }

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }

        if(buy == 0){
            int buyStock = -prices[index] + memoiz(prices, dp, index + 1, 1);
            int doNothing = memoiz(prices, dp, index + 1, 0);
            dp[index][buy] = Math.max(buyStock, doNothing);
        }else{
            int sellStock = prices[index] + memoiz(prices, dp, index + 2, 0); //since after selling i cant pick next element so i jump to index + 2
            int doNothing = memoiz(prices, dp, index + 1, 1);   
            dp[index][buy] =  Math.max(sellStock, doNothing);
        }

        return dp[index][buy];
    }*/


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 0){
                    int buyStock = -prices[index] + dp[index + 1][1];
                    int doNothing = dp[index + 1][0];
                    dp[index][buy] = Math.max(buyStock, doNothing);
                }else{
                    int sellStock = prices[index] + dp[index + 2][0]; //since after selling i cant pick next element so i jump to index + 2
                    int doNothing = dp[index + 1][1];   
                    dp[index][buy] =  Math.max(sellStock, doNothing);
                }
            }
        }
        return dp[0][0];
    }
}