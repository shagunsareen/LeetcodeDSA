class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int firstIndex = getFirstIndex(nums, target);
        int lastIndex = getLastIndex(nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    private int getFirstIndex(int[] nums, int target){
        //find first position of an element in sorted array using binary search
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int firstIndex  = -1; //we assume this is the max index of first occurrance of target

        while(left <= right){
            int mid = left + (right - left )/2;

            if(nums[mid] == target)
            {
                firstIndex = mid;
                right = mid - 1; 
            }else if(nums[mid] < target)
            {
                left = mid + 1;
            }else if(nums[mid] > target)
            {
                right = mid - 1;
            }
        }
        return firstIndex;
    }

    private int getLastIndex(int[] nums, int target){
        //find first position of an element in sorted array using binary search
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int lastIndex  = -1; //we assume this is the max index of first occurrance of target

        while(left <= right){
            int mid = left + (right - left )/2;

            if(nums[mid] == target)
            {
                lastIndex = mid;
                left = mid + 1; 
            }else if(nums[mid] < target)
            {
                left = mid + 1;
            }else if(nums[mid] > target)
            {
                right = mid - 1;
            }
        }
        return lastIndex;
    }
}