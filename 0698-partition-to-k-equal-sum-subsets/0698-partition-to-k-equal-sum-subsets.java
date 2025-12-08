class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalArraySum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            totalArraySum += nums[i];
        }
        
        //if total sum is not divisible by k we cant make subsets
        if(totalArraySum % k != 0)
        {
            return false;
        }

        Arrays.sort(nums);
        reverse(nums);

        int target = totalArraySum/k;
        boolean[] taken = new boolean[n];

        return backtrack(nums, 0, 0, taken, 0, target, k);
    }

    private void reverse(int[] arr){
        int n = arr.length;
        for(int i=0, j=n-1; i<j; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private boolean backtrack(int[] arr, int index, int count, boolean[] taken, int curr, int target, int partitionK)
    {
        if(curr > target){
            return false;
        }

        if(count == partitionK - 1){
            return true;
        }

        if(curr == target){ //one subset is found increment the count 
            return backtrack(arr, 0, count + 1, taken, 0, target, partitionK);
        }

        for(int i = index; i<arr.length; i++)
        {
            if(!taken[i]){

                taken[i] = true;

                if(backtrack(arr, i + 1, count, taken, curr + arr[i] , target, partitionK)){
                    return true;
                }

                taken[i] = false;
            }
            
        }

        return false;
    }
}