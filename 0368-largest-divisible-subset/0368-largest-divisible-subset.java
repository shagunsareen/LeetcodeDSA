class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n]; //to store index of element which made this dp count greatest
        int max = Integer.MIN_VALUE;
        int lastIndex = -1;

        for(int i=0; i<n; i++)
        {   
            hash[i] = i; //every subset starts with itself first if it doesnt have any smaller element in subset
            for(int j=0; j<i; j++){ //this gives us length of largest subset till this index so we update max post this loop completes so that we have index to backtrack 
                if((nums[i] % nums[j] == 0) && (dp[i] < 1 + dp[j])){
                    dp[i] = 1 + dp[j];
                    hash[i] = j; //taking element of jth index in subset 
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(nums[lastIndex]);
        //traverse back to get all elements
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }

        return res;
    }
}