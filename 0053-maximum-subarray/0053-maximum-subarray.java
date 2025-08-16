class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        //kadane's algo
        int maxSum = Integer.MIN_VALUE; //can't take 0 as if all elements are negative then 0 would be maxsum which is not true

        int sum = 0;

        for(int num : nums){
            sum += num;

            maxSum = Math.max(sum, maxSum);

            if(sum < 0){
                sum = 0; //reset
            }
        }
        return maxSum;
    }
}