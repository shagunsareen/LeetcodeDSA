class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        //find maxSubarraySum 
        //find minSubarraySum
        //find totalSum
        //circularMaxSum = totalSum - minSubarraySum when all elements are not negative else totalsum would be same as minsubarraySum then ans should be just normal maxSubarrraySum

        int maxSum = Integer.MIN_VALUE;
        int currMaxSum = 0;
        int currMinSum = 0;
        int minSum = Integer.MAX_VALUE;
        int totalSum = 0;

        for(int num : nums){
            
            currMaxSum += num;
            maxSum = Math.max(currMaxSum, maxSum);

            //if maxSum is negative then negate it
            if(currMaxSum < 0){
                currMaxSum = 0;
            }

            currMinSum += num;
            minSum = Math.min(minSum, currMinSum);

            if(currMinSum > 0){ //to get the lowest sum possible with negative elements
                currMinSum = 0;
            }

            totalSum += num;
        }

        if(totalSum == minSum){//if all elements are negative
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}