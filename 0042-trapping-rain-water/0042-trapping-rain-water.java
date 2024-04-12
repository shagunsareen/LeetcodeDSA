class Solution {
    public int trap(int[] height) {
        
        //we need leftMax and rightMax at every point 
        int n = height.length;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        //create leftMax array 
        int[] leftMaxArr = new int[n];
        for(int i=0; i<n; i++){
            if(leftMax < height[i])
                leftMax = height[i];
            leftMaxArr[i] = leftMax;
        }
        
        //create rightMax array
        int[] rightMaxArr = new int[n];
        for(int i=n-1; i>=0; i--){
            if(rightMax < height[i])
                rightMax = height[i];
            rightMaxArr[i] = rightMax;
        }
        
        //now we need to calculate the water trapped
        // water trapped can be min of max leftheight and max rightheight, we need to subtract actual height of a place since that will decrease the water that can be trapped 
        int waterTrapped = 0;
        for(int i=1; i<n-1; i++){
            waterTrapped += Math.max(Math.min(leftMaxArr[i-1], rightMaxArr[i+1]) - height[i], 0);
        }
        
        return waterTrapped;
    }
}