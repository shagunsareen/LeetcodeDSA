class Solution {
    public int maxProfit(int[] prices) {
        
        //maintain min value from left while considering every right ptr val as selling day 
        int leftMin = prices[0]; //buy
        int maxProfit = 0;
        
        for(int right=0; right<prices.length; right++){
            int curr = prices[right];

            int currProfit = prices[right] - leftMin;
            maxProfit = Math.max(maxProfit, currProfit);

            leftMin = Math.min(leftMin, curr);
        }

        return maxProfit;
    }
}