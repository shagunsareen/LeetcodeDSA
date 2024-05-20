class Solution {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        //capture each bit that is set in any of the elements with bitwise OR
        for(int num : nums){
            result |= num; 
        }
        
        //append the result by n-1 zeros
        return result << (nums.length-1);
    }
}