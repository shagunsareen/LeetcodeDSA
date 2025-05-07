class Solution {
    public int maxProfit(int[] prices) {
        //Approach 1
       /* int n = prices.length;
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
        */
        int n = prices.length;
        int leftMin = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for(int j=1; j<n; j++){
            maxProfit = Math.max(maxProfit, prices[j] - leftMin);
            leftMin = Math.min(leftMin, prices[j]);
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}