class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        if(n==1) return nums[0];

        //create two separate lists one without first element and second without last element
        int[] first = new int[n];
        int[] second = new int[n];

        for(int i=0; i<n; i++){
            if(i!=0) second[i] = nums[i];
            if(i!=n-1) first[i] = nums[i];
        }

        int firstArrCost = getMaxRobAmount(n-1, first);

        Arrays.fill(dp, -1);

        int secondArrCost = getMaxRobAmount(n-1, second);

        return Math.max(firstArrCost, secondArrCost);
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