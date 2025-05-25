class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        //update left product and right product in answer array directly
        int[] ans = new int[n];

        ans[0] = 1; 

        for(int i=1; i<n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        //update rp with rp variable 
        int rp = 1;
        for(int j=n-1; j>=0; j--){
            ans[j] = ans[j] * rp;
            rp = rp * nums[j]; //for next set of elements
        }

        return ans;
    }
}