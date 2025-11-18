class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;

        //calculate water level at each index for which we need leftmax and rightmax height
        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int j=n-2; j>=0; j--){
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        for(int k=1; k<n-1; k++){
            totalWater += Math.min(leftMax[k], rightMax[k]) - height[k];
        }

        return totalWater;
    }
}