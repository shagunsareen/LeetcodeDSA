class Solution {
    public int[] productExceptSelf(int[] nums) {
        //product array prefix product
        int n = nums.length;

        int[] ans = new int[n];

        ans[0] = 1;

        for(int i=1; i<=n-1; i++){
            ans[i] = nums[i-1] * ans[i-1];
        }

        int rp = 1;
        for(int i=n-1; i>=0; i--){
            ans[i] = ans[i] * rp;
            rp = rp * nums[i];
        }
        return ans;
    }
}