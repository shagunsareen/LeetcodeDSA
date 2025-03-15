class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            sum += nums[i]; //adding elements to the sum till sum reaches 0 or become negative 
            maxSum = Math.max(sum, maxSum);

            if(sum <= 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}