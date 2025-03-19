class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int operations = 0;

        //to convert the bits till last window
        for(int i=0; i<n-2; i++){
            if(nums[i] == 1){
                continue; //don't do anything if the current bit is 1 
            }else{
                 flipWindow(nums, i);
                 operations++;
            } 
        }

        //step to confirm if entire last window is 1 or not ..we won't do any operations after n-3 since window size is minimum 3 and operation happens on first element of last window and other two bits are impacted on which further operations can't be done. So we need to check there values separately.
        if(nums[n-2] == 0 || nums[n-1] == 0){
            return -1; 
        }

        return operations;
    }

    private void flipWindow(int[] nums, int pos){
        nums[pos] ^= 1; //xor of a num with 1 will flip the bit at that position i.e. if curr bit is 1 then 1^1 = 0 and if curr bit is 0 then 0^1=1
        nums[pos + 1] ^= 1;
        nums[pos + 2] ^= 1;
    }
}