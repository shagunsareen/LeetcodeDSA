class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        //get sum of the array 
        for(int num : nums){
            totalSum += num;
        }

        //odd sum - equal sum subsets not possible
        if(totalSum % 2 != 0) return false;

        //even sum - get subsets 
        int n = nums.length;
        int halfSum = totalSum/2;
        int[][] dp = new int[n][halfSum + 1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return memoization(n-1, nums, dp, halfSum);
    }


    private boolean memoization(int index, int[] nums, int[][] dp, int target){
        if(index < 0) return false;
        
        if(index == 0 && nums[index] == target){//1. reach 0th index 
            return true;
        }

        if(target == 0){   //2. target is reached
            return true;
        }

        if(dp[index][target] != -1){
            return dp[index][target] == 1 ? true : false;
        }

        boolean take = false;

        //take element 
        if(target >= nums[index] ){
            take = memoization(index - 1, nums, dp, target - nums[index]);
        }
        
        //not take element
        boolean notTake = memoization(index - 1, nums, dp, target);
        
        dp[index][target] = (take || notTake) == true ? 1 : 0;

        return (take || notTake);
    }

}