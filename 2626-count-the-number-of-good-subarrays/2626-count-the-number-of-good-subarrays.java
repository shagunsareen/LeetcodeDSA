class Solution {

    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int left = 0; 
        int right  = 0;
        int equal_pairs = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        long good_subarr = 0;

        while(left < n){
             //fix left pointer and move right pointer until we reach k valid pairs 
            while(right < n && equal_pairs < k){
                freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
                if(freq.get(nums[right]) >=2 ){
                    equal_pairs += freq.get(nums[right]) - 1; //if freq is 2 pairs would be 1 
                }
                right++;
            }

           //got k valid pairs till right-1 so post this whatever be the right index valid subarray is possible from start index
           if(equal_pairs >= k){
            good_subarr += n - right + 1;
           }

            //now move the left pointer
            int leftNum = nums[left];
            //check freq of this num and decrease by 1
            freq.put(leftNum, freq.get(leftNum) - 1);
            if(freq.get(leftNum) > 0){ //since we have decreased it already so actual freq would have been curr + 1
                equal_pairs -= freq.get(leftNum); //since pairs would be same as no. of left 1s
            }

            left++;
        }
        return good_subarr;
    }
}