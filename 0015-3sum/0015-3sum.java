class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums); //now fix one index and apply two sum on other two indices

        for(int i=0; i<n; i++){
            int j = i + 1;
            int k = n - 1;

            if(i>0 && nums[i] == nums[i-1]){
               continue;
            }

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    
                    //skip duplicates 
                    while(j<k && nums[j] == nums[j-1])
                    {
                        j++;
                    }
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}