class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int start = 0;
        int result = 0;
        int currentSum = 0;
        int k = 10001;
        int[] countMap = new int[k];
        for (int end = 0; end < nums.length; end++) {
            int currentElement = nums[end];
            countMap[currentElement]++;
            currentSum += currentElement;
            while (start < end && countMap[currentElement] > 1) {
                countMap[nums[start]]--;
                currentSum -= nums[start];
                start++;
            }
            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }
        return result;
    }
}