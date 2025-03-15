class Solution {
    public int minCapability(int[] nums, int k) {
        
        //since we need to find min capability of robber to steal the answer would be between min and max value of input array
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int i : nums){
            right = Math.max(right, i);
            left = Math.min(left, i);
        }

        int ans = 0;

        //now we know the range i.e from minNums to maxNums
        while(left <= right){
            int mid = (left + right)/2;

            if(checkHousesStolen(nums, k, mid)){
                ans = mid;
                right = mid - 1; //since we need to get the min capability 
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean checkHousesStolen(int[] nums, int k, int minCapacityGuess){
        int housesStolen = 0;

        //check in entire array how many houses we will be able to stole
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] <= minCapacityGuess){
                housesStolen++;
                i++; //since we need to skip next house
            }
        }

        return housesStolen >= k;
    }
}