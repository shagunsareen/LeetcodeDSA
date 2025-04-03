class Solution {
    public long maximumTripletValue(int[] nums) {
        
        //get right max array since nums[k] should be max 
        int n = nums.length;
        int[] rightMax = new int[n];
        int maxValue = nums[n-1]; //last element

        for(int i=n-2; i>=0; i--){
            rightMax[i] = maxValue;
            maxValue = Math.max(nums[i], maxValue); //updating max for next iteration as it includes curr element
        }

       //find max triplet
       long maxTriplet = 0;
       int maxLeft = nums[0];
       for(int i=1; i<n-1; i++){ //this i represents y in equation x-y so y can go only till n-2 since n-1 should be z then
          maxTriplet = Math.max(maxTriplet, (long)(maxLeft - nums[i])*rightMax[i]);
          maxLeft = Math.max(maxLeft, nums[i]); //update maxLeft for next element
       }

       return maxTriplet;
    }
}