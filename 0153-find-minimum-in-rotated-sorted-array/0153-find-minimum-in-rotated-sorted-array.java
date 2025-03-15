class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int ans = Integer.MAX_VALUE;

        //find which part of the array is sorted and then get min from that part
        while(left <= right){
            int mid = (left + right)/2;

            //check if the entire array is sorted
            if(nums[left] <= nums[right]){
                ans = Math.min(ans, nums[left]);
                break; //since we got the answer
            }else if (nums[left] <= nums[mid]){ //left part is sorted
                ans = Math.min(ans, nums[left]);
                left = mid + 1; //to get min from right part because we might have min on right side
            }else if(nums[mid] <= nums[right]){
                ans = Math.min(ans, nums[mid]); //right part is sorted
                right = mid - 1; //to get min from left part 
            }
        }

        return ans;
    }
}