class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //approach 1
        /*int n = nums.length;
        
        int[] left = new int[n];
        left[0] = 1;
        
        int[] right = new int[n];
        right[n-1] = 1;
        
        //create the left product prefix array 
        for(int i=1; i<n; i++){
            left[i] = left[i-1]*nums[i-1];   
        }

        //create the right product suffix array
        for(int j=n-2; j>=0; j--){
            right[j] = right[j+1]*nums[j+1];   
        }
        
        int[] ans = new int[n];
        
        //creating the ans array
        for(int k=0; k<n; k++){
            ans[k] = left[k]*right[k];
        }*/
        
        //approach 2
        int n = nums.length;
        int[] ans = new int[n];
        int curr = 1;  //we will keep on updating this value to get product
        Arrays.fill(ans, 1);
        
        for(int i=0; i<n; i++){
            ans[i] *= curr;
            curr *= nums[i];
        }
        
        curr = 1;
        for(int j=n-1; j>=0; j--){
            ans[j] *= curr;
            curr *= nums[j];
        }
        
        return ans;
    }
}