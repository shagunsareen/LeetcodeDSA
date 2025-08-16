class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1; //no ele on left
        for(int i=1; i<n; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[n-1] = 1; //no ele on right
        for(int j=n-2; j>=0; j--){
            right[j] = right[j+1] * nums[j+1];
        }

        //final array
        int[] ans = new int[n];
        for(int k=0; k<n; k++){
            ans[k] = left[k] * right[k];
        }

        return ans;
    }
}