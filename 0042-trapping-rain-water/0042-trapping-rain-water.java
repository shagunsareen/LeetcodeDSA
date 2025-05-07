class Solution {
    public int trap(int[] height) {
    
        int n = height.length;
        /* Approach 1
        
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        for(int j=n-2; j>=0; j--){
            rightMax[j] = Math.max(rightMax[j+1], height[j+1]);
        }

        int totalWater = 0;
        for(int i=1; i<n-1; i++){
            totalWater += Math.max(Math.min(leftMax[i],rightMax[i]) - height[i], 0);
        }

        return totalWater; */

        //Approach 2 
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        //take side which has lower height
        while(left < right){

            if(height[left] < height[right]){ 
                if(height[left] >= leftMax){
                    leftMax = height[left]; //update left max since curr h is greater than lmax
                }else{
                    totalWater += leftMax - height[left];
                }
                 left++;
            }else {
                if(height[right] >= rightMax){
                    rightMax = height[right]; //update left max since curr h is greater than lmax
                }else{
                    totalWater += rightMax - height[right];
                }
                right--;
            }   
        }
        return totalWater;
    }
}