class Solution {
    public long continuousSubarrays(int[] nums) {
        int left = 0 ;
        int right = 0;
        
        long count = 0;
        long windowLen = 0;
        int currMin = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;
        
        
        while(right < nums.length){
            currMax = Math.max(currMax, nums[right]);
            currMin = Math.min(currMin, nums[right]);
            
            if(currMax - currMin > 2){//window breaks here so calculate subarrays for last window
                windowLen = right - left;
                count += (windowLen*(windowLen+1))/2;
                
                //move left to right and move it backwards to see till where we can have window to restart since curr right might have elements on the left which can be included in it's window
                left = right;
                currMax = currMin = nums[right];
                
                while (left > 0 && Math.abs(nums[right] - nums[left-1]) <= 2) { 
                    left--;
                    currMin = Math.min(currMin, nums[left]);
                    currMax = Math.max(currMax, nums[left]);
                }

                
                //now we have reached till point where left can start from so remove overcounted subarrays if left is expanded
                if(left < right){
                    windowLen = right - left;
                    count -= (windowLen*(windowLen+1))/2;
                }
            } 
             right++;   
        } 
            //count for the last window as we won't be able to see if it had any greater diff ele or not OR if no greater diff ele comes then subarrays wont be counted so we need this 
            windowLen = right - left;
            count += (windowLen*(windowLen+1))/2;
           
        return count;
    }
}