class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        //sort the array and find longest increasing subsequence 
        Arrays.sort(nums); 
        int[] dp = new int[n];
        Arrays.fill(dp, 1); //since every element in itself is LIS of length 1 i.e. dp array should store length of lis till ith index

        //if we take each element as end index of lis then all elements before it should be taken in denomenator to check divisibility
        int maxLis = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    if(maxLis < dp[i]){
                        maxLis = dp[i];
                    }
                }
            }
        }

        //Find LIS
        int prev = -1;
        for(int i=n-1; i>=0; i--){
            if(dp[i] == maxLis && (prev == -1 || prev % nums[i] == 0)){
                result.add(nums[i]);
                maxLis--;
                prev = nums[i];
            }
        }
        
        return result;
    }
}