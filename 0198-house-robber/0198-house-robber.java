class Solution {
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
}