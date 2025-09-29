class Solution {
    //Memoization
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1]; //dp will store length of subsequence starting from ith index where last element considered was at prev_index
        //since curr index will range from 0 to n, prev_index will range from -1 to n-1 so we take second element size in dp array till n+1 
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return memoiz(dp, nums, 0, -1);
    }

    private int memoiz(int[][] dp, int[] nums, int index, int prev_index){
        //base case
        if(index == nums.length){
            return 0;
        }

        if(dp[index][prev_index + 1] != -1){
            return dp[index][prev_index + 1];
        }

        int take = 0;
        int notTake = 0;

        //take
        if(prev_index == -1 || nums[index] > nums[prev_index]){
            take = 1 + memoiz(dp, nums, index + 1, index); //increase length, update to next index, update prev index to curr index
        }
        
        notTake = memoiz(dp, nums, index + 1, prev_index);

        dp[index][prev_index + 1] = Math.max(take, notTake);

        return dp[index][prev_index + 1];
    }
}