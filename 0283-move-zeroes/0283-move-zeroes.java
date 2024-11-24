class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;  // Tracks the position to place the next non-zero element
        
        //because order has to be maintained hence we cant swap non zero elements from right to 0 elements  from left, we have to swap non zero elements while iterating to left zeroth element so that we can move non zero elements to left. Since if we swap when we encounter 0 there can be case where it doesn't need swap eg [1,0] should not be swapped to [0,1]
        
        for(int i=0; i<nums.length; i++){           
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;  //i is anyways moving forward and checking non zero elements, it swaps elements when we get non zero so that non zero ones reach left position. once we swap we want to keep next non zero at next possible location
            }
        }
    }
}