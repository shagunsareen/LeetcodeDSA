class Solution {
    
    //Memoization 
    /*int[] dp;
    public int rob(int[] nums) {
        //split array into 2 arrs, one with last element and one without last element
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        if(n == 1) return nums[0];

        int[] first = Arrays.copyOfRange(nums, 0, n-1);
        int[] second = Arrays.copyOfRange(nums, 1, n); 

        int firstCost  = robFrom(0, first);
        Arrays.fill(dp, -1);
        int secondCost = robFrom(0, second);

        return Math.max(firstCost, secondCost);
    }

    private int robFrom(int index, int[] nums){
        if(index >= nums.length){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index] + robFrom(index + 2, nums);
        int dontPick = robFrom(index + 1, nums);

        dp[index] = Math.max(pick, dontPick);

        return dp[index];
    }

    //Tabulation
    int[] dp;
    public int rob(int[] nums) {
        //split array into 2 arrs, one with last element and one without last element
        int n = nums.length;

        dp = new int[n+1];
        Arrays.fill(dp, -1);

        if(n == 1) return nums[0];

        int[] first = Arrays.copyOfRange(nums, 0, n-1);
        int[] second = Arrays.copyOfRange(nums, 1, n); 

        int firstCost  = robFrom(first);
        Arrays.fill(dp, -1);
        int secondCost = robFrom(second);

        return Math.max(firstCost, secondCost);
    }

    private int robFrom(int[] nums){
        int n = nums.length;
        dp[n-1] = nums[n-1];
        dp[n] = 0;
        for(int i=n-2; i>=0; i--){
            int pick = dp[i+2] + nums[i];
            int dontPick = dp[i+1];

            dp[i] = Math.max(pick, dontPick);
        }
        return dp[0];
    }*/

    //Space optimised
    public int rob(int[] nums) {
        //split array into 2 arrs, one with last element and one without last element
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] first = Arrays.copyOfRange(nums, 0, n-1);
        int[] second = Arrays.copyOfRange(nums, 1, n); 

        int firstCost  = robFrom(first);
        int secondCost = robFrom(second);

        return Math.max(firstCost, secondCost);
    }

    private int robFrom(int[] nums){
        int n = nums.length;

        int next = nums[n-1];
        int nextAdjacent = 0;

        for(int i=n-2; i>=0; i--){
            int pick = nextAdjacent + nums[i];
            int dontPick = next;

            int currMax = Math.max(pick, dontPick);
            nextAdjacent = next;
            next = currMax;
        }
        return next;
    }
}

