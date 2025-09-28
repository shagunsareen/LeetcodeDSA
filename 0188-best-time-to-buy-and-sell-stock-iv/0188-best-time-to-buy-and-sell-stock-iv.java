class Solution {
    public int maxProfit(int k, int[] prices) {
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
    }
}