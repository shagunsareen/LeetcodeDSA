class Solution {
    /*public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][k+1];
        int[][] curr = new int[2][k+1];

        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
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
        return prev[0][k];
    }*/

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return memoiz(prices, k, 0, n, 0, dp);
    }

    //memoiz
    private int memoiz(int[] prices, int k, int index, int n, int transNo, int[][] dp){
        //base case 
        if(index == n || transNo == 2*k){
            return 0;
        }

        if(dp[index][transNo] != -1){
            return dp[index][transNo];
        }

        if(transNo % 2 == 0){ //buy 
            int buy =   -prices[index] + memoiz(prices, k, index+1, n, transNo + 1, dp);
            int doNothing = memoiz(prices, k, index+1, n, transNo, dp);
            dp[index][transNo] = Math.max(buy, doNothing);
        }else{
            int sell =  prices[index] + memoiz(prices, k, index+1, n, transNo + 1, dp);
            int doNothing = memoiz(prices, k, index+1, n, transNo, dp);
            dp[index][transNo] = Math.max(sell, doNothing);
        }

        return dp[index][transNo];
    } 
}