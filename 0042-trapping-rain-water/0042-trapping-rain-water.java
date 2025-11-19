class Solution {
    public int trap(int[] height) {

        //Approach 1 - O(n), SC - O(n)
        int n = height.length;
        int totalWater = 0;

        //calculate water level at each index for which we need leftmax and rightmax height
        /*int[] leftMax = new int[n];
        leftMax[0] = height[0];

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i=1; i<n; i++){ //leftMax includes curr height at ith index also 
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int j=n-2; j>=0; j--){ //rightMac includes curr height at jth index also 
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        for(int k=1; k<n-1; k++){
            totalWater += Math.min(leftMax[k], rightMax[k]) - height[k];
        }*/


        //Approach 2 - TC : O(n), SC : O(1)
        
        int left = 0;
        int right = n-1;

        int leftMax = height[left];
        int rightMax = height[right];

        while(left < right){

            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
                right--;
            }
        }
        
        return totalWater;
    }
}