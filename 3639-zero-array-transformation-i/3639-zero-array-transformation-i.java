class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        Arrays.fill(prefixSum, 0);

        for(int[] query : queries){
            int startIndex = query[0];
            int endIndex = query[1];

            prefixSum[startIndex] += -1;

            if(endIndex + 1 < n){
                prefixSum[endIndex+1] += 1; 
            }
        }

        //calculate prefixSum
        for(int i=1; i<n; i++){
            prefixSum[i] += prefixSum[i-1];
        }

        boolean allZeros = true;
        for(int j=0; j<n; j++){
            //nums[j] -= Math.min(nums[j], prefixSum[j]);
            nums[j] -= Math.min(nums[j], Math.abs(prefixSum[j]));
            if(nums[j] != 0)
            {
                allZeros = false; 
                return allZeros;
            }
        }
        return allZeros;
    }
}