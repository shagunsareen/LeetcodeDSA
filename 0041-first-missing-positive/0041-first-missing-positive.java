class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains1 = false;
        
        //check if 1 is not present return that
        //mark non negative, 0, >n numbers as 1
        for(int i=0; i<n; i++){
            if(nums[i]==1)
                contains1 = true;
            
            if(nums[i] <= 0 || nums[i] >n){
                nums[i] = 1;
            }
        }
        
        if(!contains1)
            return 1;  //smallest positive integer
        
        //now we have only positive integers in the array, lets mark index i.e. nums[index] as negative which will mean that index                 number is present in the array
        
        for(int i=0; i<n; i++){
            int value = Math.abs(nums[i]);
            //if we get the value as n then we dont have n+1 position to store so we can store it at 0th index
            if(value == n){
                nums[0] = -Math.abs(nums[0]);
            }else{
                nums[value] = -Math.abs(nums[value]);
            }   
        }
        
        //now check for all numbers between 1 to n whether those are marked negative or not in the array
        for(int i=1; i<n; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        
        if(nums[0] > 0)
            return n;
        
        //if array contains all elements from 1 to n then n+1 is the answer
        return n+1;
    }
}