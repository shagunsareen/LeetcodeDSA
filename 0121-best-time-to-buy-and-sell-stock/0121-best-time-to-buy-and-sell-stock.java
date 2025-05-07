class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] leftMin = new int[n];
        leftMin[0] = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            leftMin[i] = Math.min(leftMin[i-1] , prices[i-1]);
        }

        int maxProfit = Integer.MIN_VALUE;
        for(int j=1; j<n; j++){
            maxProfit = Math.max(maxProfit, prices[j] - leftMin[j]);
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}