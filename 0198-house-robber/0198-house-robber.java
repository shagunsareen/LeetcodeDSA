class Solution {
    /*
     // Approach 1 - Recursion with Memoization
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);

        return robFrom(0, nums);
    }

    //max amount if we rob from this index to end houses
    private int robFrom(int index, int[] nums){
        if(index >= nums.length){
            return 0;
        }

        if(memo[index] > -1)
        {
            return memo[index];
        }

        int amount = Math.max(robFrom(index + 1, nums) , 
                              robFrom(index + 2, nums) + nums[index]);

        memo[index] = amount;
        return memo[index];

        }
        

        //Approach 2 - Tabulation, iteration - we go from right to left as we dont know which house on the right has more value 
        public int rob(int[] nums) {
            int n = nums.length;

            int[] dp = new int[n+1];

            dp[n-1] = nums[n-1]; //choosing this house and nothing on right
            dp[n] = 0; //nothing on right

            for(int i=n-2; i>=0; i--){
                int pick = dp[i+2] + nums[i];
                int dontPick = dp[i+1];

                dp[i] = Math.max(pick, dontPick);
            }

            return dp[0];
        } */


        //Approach 3 : Space optimised 
        public int rob(int[] nums) {
            int n = nums.length;

            int nextFirst = nums[n-1]; //choosing this house and nothing on right
            int nextSecond = 0; //nothing on right

            for(int i=n-2; i>=0; i--){
                int pick = nextSecond + nums[i];
                int dontPick = nextFirst;

                int current = Math.max(pick, dontPick);
                nextSecond = nextFirst;
                nextFirst = current;  
            }

            return nextFirst;
        }
}