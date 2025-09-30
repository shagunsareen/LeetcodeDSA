class Solution {
    //Memoization
    /*public int lengthOfLIS(int[] nums) {
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
    }*/


    //Tabulation
     /*public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1]; //since we have to take care of base case when index == n returned 0 in memoization so we keep n+1 to store nth index value
        
        for(int index = n-1; index >= 0; index--){ // 0 to n-1
            for(int prev_index = index-1; prev_index >= -1; prev_index--){ //-1 to n-1 
                    int take = 0;
                    int notTake = 0;
                    
                    if(prev_index == -1 || nums[index] > nums[prev_index]){
                        take = 1 + dp[index + 1][index + 1]; //since we are storing prev indexes after shifting it by 1
                    }

                    notTake = dp[index + 1][prev_index + 1];

                    dp[index][prev_index + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }*/

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1); //since if we consider element itself then LIS is 1 for that element

        //store LIS length till every index 
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && (1 + dp[j] > dp[i])){
                    dp[i] = 1 + dp[j];
                }
            }
            //update max LIS
            if(dp[i] > res){
                res = dp[i];
            }
        }

        return res;
    }
}