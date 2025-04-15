class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //get the totalSum 
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        if (totalSum - target < 0 || (totalSum - target) % 2 == 1)
            return 0;

        //we have to find subsets with (totalSum - target)/2 diff 
        int s2Sum = (totalSum - target)/2;
        int s1Sum = totalSum - s2Sum;

        return countPartitions(nums, s2Sum);
    }

    int[][] dp;
    private int countPartitions(int[] nums, int sum){
        int n = nums.length;
        dp = new int[n][sum + 1]; // n - index , target + 1 - sum at each col

        //0th row 
        if(nums[0] == 0){
            dp[0][0] = 2; //either take 0 or not sum is achieved
        }else{
            dp[0][0] = 1; //not pick 
            if(nums[0] <= sum){ //meaning we can pick element at 0th index since its value is less than the target
                dp[0][nums[0]] = 1;
            }
        }

        for(int index = 1; index < n; index++){
            for(int target = 0; target <= sum; target++){

                int notPick = dp[index-1][target];

                int pick = 0;

                if(nums[index] <= target){
                    pick = dp[index-1][target - nums[index]];
                }

                dp[index][target] = pick + notPick;
            }
        }
        return dp[n-1][sum];
    }
}