class Solution {
    public int maxArea(int[] height) {
        //O(n2) : if i make take rectange points as i and i+1 for every index which is not efficient
        
        //O(n) : Two pointer approach 
        int size = height.length;
        
        int left = 0;
        int right = size-1;
        int maxArea = 0;
        int area = 0;
        
        while(left < right){
            area = Math.min(height[left], height[right])*(right-left);
            maxArea = Math.max(maxArea, area);

            //check which height is more and increase pointer accorindly
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }  
        return maxArea;
    }
}