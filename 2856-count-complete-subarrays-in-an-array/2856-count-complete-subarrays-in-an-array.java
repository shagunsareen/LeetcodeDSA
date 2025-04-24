class Solution {
    public int countCompleteSubarrays(int[] nums) {
        /*Approach 1
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
        return ans;*/

        //Approach 2
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int distinct = set.size();
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int n = nums.length;
        
        for(int left = 0; left < n; left++){
            while(right < n && map.size() < distinct){
                int curr = nums[right];
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                right++;
            }

            if(map.size() == distinct){
                ans += n - right + 1; //subarrays from valid window to end are all valid
            }

            //remove left
            int remove = nums[left];
            map.put(remove, map.get(remove) - 1);
            if(map.get(remove) == 0){
                map.remove(remove);
            }
        }
        return ans;
    }
}