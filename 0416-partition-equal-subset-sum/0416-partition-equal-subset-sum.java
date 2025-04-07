class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        //get total sum and see what will be the required sum from both subsets
        for(int num : nums){
            totalSum += num;
        }

        if(totalSum % 2 != 0){ //sum is odd can't divide in 2 subsets
            return false; 
        }

        return isSubsetSumK(nums, n, totalSum/2);
    }

    boolean[] prev; //this will store just target values
    private boolean isSubsetSumK(int[] nums, int n, int k){
        prev = new boolean[k+1];

        // for target 0 mark it true since its possible to have subset with sum 0 by nnot taking any element
        prev[0] = true;

        if(nums[0] <= k)
        {
            prev[nums[0]] = true;
        }

        for(int index = 1; index < n; index++){
            boolean[] curr = new boolean[k+1]; //store curr values
            curr[0] = true;
            for(int target = 0; target <= k; target++){

                boolean taken = false;
                
                if(nums[index] <= target){
                    taken = prev[target-nums[index]];
                }

                boolean notTaken = prev[target];

                curr[target] = taken || notTaken;
            }
            prev = curr;
        }

        return prev[k];
    }
}