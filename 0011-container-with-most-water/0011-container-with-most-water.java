class Solution {
    public int maxArea(int[] height) {

        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;

        while(left < right){
            int width = right - left;
            int length = Math.min(height[left], height[right]); 
            int currArea = width * length; 
            maxArea = Math.max(currArea, maxArea);   

            if(height[left] <= height[right]){ //we move shorter height pointer so that we can get better height in future 
                left++;
            }else{
                right--;
            }
        }
        
        return maxArea;
    }
}