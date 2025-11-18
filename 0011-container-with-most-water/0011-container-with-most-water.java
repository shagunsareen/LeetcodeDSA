class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left  = 0;
        int right = n-1;
        int maxArea = 0;

        while(left < right){
            int width = right - left;
            int area = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(area, maxArea);

            if(height[left] <= height[right]){ //prefer long height to get max area
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}