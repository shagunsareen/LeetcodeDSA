class Solution {
    public int specialArray(int[] nums) {
        
        //Approach 1 : TC : O(N), SC: O(N)
        int n = nums.length;
        //if we have num as 5 in nums, expectation is it should have 5 or more numbers greater than 5 however the length is lesser than 5 so we can at max have nums as the length of nums
        int[] freq = new int[n+1]; //to store freq of n we would need n+1th index
        
        for(int i=0; i<n; i++){
            freq[Math.min(n, nums[i])]++;  //store freq of elements greater than n at nth index i.e. if we have 5 we will store freq of them at 2th index if there are only 2 elements in the array
        }
        
        //suffix sum --from end to the start since we need elements greater on the right
        int numGreaterThanOrEqual = 0;
        for(int j=n; j>=0; j--){
             numGreaterThanOrEqual += freq[j];
             if(j == numGreaterThanOrEqual){
                 return j;
             }
        }
        
        return -1;
    }
}