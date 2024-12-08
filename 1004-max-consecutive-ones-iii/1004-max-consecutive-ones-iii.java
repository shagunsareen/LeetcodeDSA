class Solution {
    public int longestOnes(int[] nums, int k) {
        //we will use expanding and shrinking sliding window concept here as we dont know what would be the size of the window which includes k flips of 0s
        
        int start = 0; // we move start only when we exhaust k flips 
        int end = 0; // we move end to iterate over the entire array    
        int maxSize = 0;
        
        while(end < nums.length){
            
            if(nums[end] == 0){ 
                k--;
            }
            
            //check if k is negative then move the start until we get k as positive
            while(k < 0){
                if(nums[start] == 0){
                     k++;
                }
                start++; //increment this irrespective of value as curr window is invalid  
            }
            
            maxSize = Math.max(maxSize, end-start+1);
            //System.out.println(k + " - " +maxSize);
            end++;
        }
        
        return maxSize;
    }
}