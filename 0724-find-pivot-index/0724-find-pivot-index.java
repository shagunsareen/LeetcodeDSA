class Solution {
    public int pivotIndex(int[] nums) {
        int pivIndex = -1;
        int n = nums.length;
         
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        
        leftSum[0] = 0; rightSum[n-1] = 0;
        
        for(int i=1; i<n; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1]; //we dont have to include current element 
        }
        
        for(int j=n-2; j>=0; j--){
            rightSum[j] = rightSum[j+1] + nums[j+1];
        }
        
        for(int k=n-1; k>=0; k--){
            if(leftSum[k]==rightSum[k])
                pivIndex = k;
        }
        
        return pivIndex;
    }
}