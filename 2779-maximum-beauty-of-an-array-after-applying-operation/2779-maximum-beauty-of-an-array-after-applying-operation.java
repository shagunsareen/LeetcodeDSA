class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums); //this is imp since it will help us to decide if condition fails at one element it will fail for further elements as well
        int end = 0;
        int maxLen = 0;   
        //end will iterate over the entire array 
        //start will be incremented when condition is not satisfied 
         //we need to start window from every element to see how large window can we create by converting further elements to the starting ele in the range nums[i] + k, nums[i]-k
        //this condition makes sure every element in the window is in the expected range so that those can be converted to same number. if the difference is more than this then they cant be converted to the same number
        for(int start = 0; start<nums.length; start++){
             while(end < nums.length && nums[end] - nums[start] <= 2*k)
             {
                end++;
             } 
            maxLen = Math.max(maxLen, end-start);
        } 
        return maxLen;
    }
}