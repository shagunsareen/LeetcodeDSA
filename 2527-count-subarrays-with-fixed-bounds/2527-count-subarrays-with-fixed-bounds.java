class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minI = -1;
        int maxI = -1;
        int invalidI = -1;

        //get subarrays ending at index ith 
        for(int i=0; i<nums.length; i++){
            //check if the current ele contributes to invalid index
            if(nums[i] < minK || nums[i] > maxK){
                 invalidI = i;
            }

            //check if its min or max ele
            if(nums[i] == minK){
                minI = i;
            }

            if(nums[i] == maxK){
                maxI = i;
            }

            int validStart = Math.min(minI, maxI);
            int count = Math.max(validStart- invalidI, 0); // [2,6,5,3,4] here 0-1 = -1 so take 0 instead as count
           res += count;
        }
        return res;
    }
}