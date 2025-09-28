class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int[2];

         for(int index = n-1; index >= 0; index--){
            int[] curr = new int[2];
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 0){ //we can buy the stock - invest money and go to next index
                    int buyStock = -prices[index] - fee + prev[1];
                    int doNothing = prev[0];

                    curr[buy] = Math.max(buyStock , doNothing);
                }else if(buy == 1){ //sell case 
                    int sellStock = prices[index] + prev[0];
                    int doNothing = prev[1];

                    curr[buy] = Math.max(sellStock , doNothing);
                }
            }
            prev = curr;
         }
        return prev[0];
    }
}