class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        long prefixSum = 0;
        int right = 0;
        int left = 0;
        int n = nums.length;

        while(left < n){  //fix left 

            //move j till invalid index ad count valid subarrays i.e. right - left 
            while(right < n && ((prefixSum + nums[right]) * (right - left + 1) < k)){
                prefixSum += nums[right];
                right++;
            }

            res += right - left; //since we will either come out of it when sum > k so we are one index ahead so right - left gives us 

            if(left == right){
                right++; // both index are at one element and if that doesn't satisfy condition meaning the value itself is greater than k so dont include it hence do left++ and right++;
            }else{
                 prefixSum -= nums[left];  //move left forward 
            }
            left++;
        }

        return res;
    }
}