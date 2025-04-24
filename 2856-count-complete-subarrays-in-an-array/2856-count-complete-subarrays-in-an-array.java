class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int wholeCount = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        wholeCount = set.size();
        int n = nums.length;
 
        int ans = 0;
        Set<Integer> subarrSet;

        for(int left=0; left<n; left++){   
            subarrSet = new HashSet<>();

            for(int right = left ; right < n; right++){
                int curr = nums[right];
                subarrSet.add(curr);

                if(subarrSet.size() == wholeCount){
                    ans++;
                }
            }
        }    
        return ans;
    }
}