class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int zeroCount = 0;
        int maxSize = Integer.MIN_VALUE;
        
        while(end < nums.length)
        {
            if(nums[end] == 0)
                zeroCount++;
            
            //if we have more than 1 zero then our window is not valid , move start pointer
            while(zeroCount > 1){
                if(nums[start] == 0)
                    zeroCount--;
                start++;
            }
            
            maxSize = Math.max(maxSize, end - start); //since there will always be 1 zero in our window which we will delete so i am. not using formula end - start + 1  
            end++;
        }
        
        return maxSize;
    }
}