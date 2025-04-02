class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    long currMax = (long)(nums[i] - nums[j]) * nums[k];
                    if(currMax > 0){
                         max = Math.max(max, currMax);
                    }    
                }
            }
        }
        return max;
    }
}