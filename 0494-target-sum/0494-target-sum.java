class Solution {

    //Memoization
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if(totalSum - target < 0 || (totalSum - target) % 2 == 1) return 0;

        int targetSum = (totalSum - target)/2;
        int n = nums.length;
        int[][] dp = new int[n][targetSum + 1];

        /*for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        return memoization(nums, targetSum, n-1, dp); */

        return tabulation(nums, targetSum, dp);
    }

    private int memoization(int[] nums, int target, int index, int[][] dp){
        if(index == 0){
            if(target == 0 && nums[0] == 0){
                return 2;
            }else if( target == 0 || nums[0] == target){
                return 1; 
            }
            return 0;
        } 

        if(dp[index][target] != -1){
                return dp[index][target];
        }

        int take = 0;
        if(nums[index] <= target){
            take = memoization(nums, target - nums[index], index - 1, dp);
        }
        int notTake = memoization(nums, target, index - 1, dp);
        dp[index][target] = take + notTake;
        
        return dp[index][target];
    }

    public int tabulation(int[] nums, int target, int[][] dp) {
        int n = nums.length;

        if(nums[0] == 0){
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1; //if there is any other value on 0th index but sum we are expecting is 0 then we ignore it
        }

        if(nums[0] != 0 && nums[0] <= target){ // if value at 0th index is anything other than 0 and can be included to target sum then we will pickit
            dp[0][nums[0]] = 1; 
        }

        for(int index = 1; index < n; index++){
            for(int tar = 0; tar <= target; tar++){
                int take = 0;
                if(nums[index] <= tar){
                    take = dp[index - 1][tar - nums[index]];
                }
                int notTake = dp[index - 1][tar];
                dp[index][tar] = take + notTake;
            }
        }

        return dp[n-1][target];
    }
}