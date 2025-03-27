class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return getMaxRobAmount(n-1, nums);
    }

    private int getMaxRobAmount(int index, int[] nums){
        if(index == 0) return nums[index];

        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        //either we pick an element or we don't
        int pick = nums[index]  + getMaxRobAmount(index - 2, nums);

        int notPick = getMaxRobAmount(index - 1, nums);

        dp[index] = Math.max(pick, notPick);

        return dp[index];
    }
}