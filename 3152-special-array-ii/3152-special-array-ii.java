class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        
        //traverse and see how many violative indexes you find
        for(int i=1; i<nums.length; i++){
            if(nums[i] % 2 == nums[i-1] % 2){ // this is to check parity i.e. remainder when both numbers are divided by 2. If remainder is 1 then number is odd else number is even. If both values are same that means we have to reset the max alternative window size
                prefix[i] = 1;
            }else{
                prefix[i] = prefix[i-1] + 1; //this means we can continue to check more alternating values in the same window
            }
        }
        
        //now get ans for all the queries
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            
            if(prefix[end] >= end - start + 1){
                ans[i] = true;
            }else{
                ans[i] = false;
            }
        }
        return ans;
    }
}