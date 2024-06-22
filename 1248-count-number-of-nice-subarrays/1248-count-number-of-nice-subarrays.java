class Solution {
    //Same as question - https://leetcode.com/problems/subarray-sum-equals-k/submissions/
    public int numberOfSubarrays(int[] nums, int k) {
         //here key - preSum till i, value - frequency of subarrays with that preSum
        Map<Integer, Integer> map = new HashMap<>(); 
        int preSum = 0;
        int count = 0;
        
        map.put(0,1); //this is done so that when we get the same sum we should count the subarray as 1 and not 0 because sum-preSum=0 won't be in map and it will miss the subarray
        
        //to get the prefixSum till an index we have to traverse the array
        for(int i=0; i<nums.length; i++){
            preSum += nums[i]%2; //we will only add when numbers are off 
            
            int remainingSum = preSum - k;
            
            //if we know how many subarrays we have of sum remaining then we know there are sum no. of subarrays with sum k
            count += map.getOrDefault(remainingSum, 0);
            
            //also put the current prefixSum to the map 
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        
        return count;
    }
}