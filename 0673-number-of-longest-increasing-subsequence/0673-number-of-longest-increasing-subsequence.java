class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        int maxLength = 0;
        int res = 0;

        int[] count = new int[n]; //stores count of longest increasing subsequences
        Arrays.fill(count, 1);

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){ //check with all previous elements to see if they can be included in the subsequence
                    if(nums[j] < nums[i] && (1 + dp[j] > dp[i])){
                        dp[i] = 1 + dp[j]; //update length 
                        count[i] = count[j]; //update count with what previous element count was
                    }else if(nums[j] < nums[i] && (1 + dp[j] == dp[i])){
                        //since dp[i] will have same length for diff j's here update that count
                        count[i] += count[j]; //how many subsequences were made with earlier element so we will include that count 
                    }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        //now we know maxLength now we need to see which all indexes have this length LIS then take count that the LIS can be formed in how many ways
        for(int i=0; i<n; i++){
            if(dp[i] == maxLength){
                res += count[i];
            }
        }
        return res;
    }
}