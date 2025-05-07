class Solution {
    public int trap(int[] height) {
        
        //Approach 1 : SC :O(2n)
        
        /*int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];

        // iterate to get left max
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //iterate to get right max
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int totalWaterTrapped = 0;

        //now calculate the water trapped
        for(int i=1; i<n-1; i++){
            totalWaterTrapped += Math.max((Math.min(leftMax[i-1], rightMax[i+1]) - height[i]),0);
            System.out.println("LM : "+leftMax[i]+ ", RM : "+rightMax[i]+", Ht : "+height[i]+",WT: "+totalWaterTrapped);
        }

        return totalWaterTrapped;*/

        int n = height.length;
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

        return totalWater;

        //Approach 2 : without arrays
        /*int n = height.length;
        int lmax =height[0];
        int rmax =height[n-1];
        int totalWater = 0;
        int l =0;
        int r =n-1;

        while(l<r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            totalWater+=(lmax<rmax) ? lmax-height[l++] : rmax-height[r--];
        }

        return totalWater;*/
    }
}