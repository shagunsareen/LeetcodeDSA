class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int leftMin = prices[0];
        int maxProfit = 0;

        for(int i=0; i<n; i++){
           int profit =  prices[i] - leftMin;
           leftMin = Math.min(leftMin, prices[i]);
           maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}