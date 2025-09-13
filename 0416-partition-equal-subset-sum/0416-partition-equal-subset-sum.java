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
        
        return spaceOptimization(nums, halfSum);

        /*int[][] dp = new int[n][halfSum + 1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return memoization(n-1, nums, dp, halfSum);*/
    }


    /*private boolean memoization(int index, int[] nums, int[][] dp, int target){
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

    private boolean tabulation(int[] nums, int sum){
        int rows = nums.length;
        int cols = sum + 1;
        boolean[][] dp = new boolean[rows][cols];  // store index as rows and sum as cols 
        
        //fill base cases
        //1. if sum is 0 then it is achievable at every index
        for(int row = 0; row < rows; row++){
            dp[row][0] = true;
        }

        //2. in 0th row we consider only first element from the array so if our required target is same as that element or lesser so that we can take more elements later then we can consider it 
        if(nums[0] <= sum){
            dp[0][nums[0]] = true;
        }

        for(int index = 1; index < rows; index++){
            for(int target = 1; target <= sum; target++){
                boolean take = false;
                
                if(target >= nums[index] ){
                    take = dp[index - 1][target - nums[index]];
                }
                
                //not take element
                boolean notTake = dp[index - 1][target];
                
                dp[index][target] = (take || notTake);
            }
        }

        return dp[rows - 1][sum];
    } */

    private boolean spaceOptimization(int[] nums, int sum){
        int rows = nums.length;
        int cols = sum + 1;
        boolean[] prev = new boolean[cols];  // store index as rows and sum as cols 
        
        //fill base cases
        //1. if sum is 0 then it is achievable at every index
        prev[0] = true;

        //2. in 0th row we consider only first element from the array so if our required target is same as that element or lesser so that we can take more elements later then we can consider it 
        if(nums[0] <= sum){
            prev[nums[0]] = true;
        }

        for(int index = 1; index < rows; index++){
            
            boolean[] curr = new boolean[cols];

            for(int target = 1; target <= sum; target++){
                boolean take = false;
                
                if(target >= nums[index] ){
                    take = prev[target - nums[index]];
                }
                
                //not take element
                boolean notTake = prev[target];
                
                curr[target] = (take || notTake);
            }
            prev = curr;
        }

        return prev[sum];
    }


}