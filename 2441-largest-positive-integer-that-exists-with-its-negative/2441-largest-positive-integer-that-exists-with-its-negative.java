class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = -1;
        
        for(int num : nums){
            //check if -num is present in set
            if(set.contains(-num)){
                ans = Math.max(ans, Math.abs(num));
            }
             set.add(num); // Insert the current number into the set
        }
        return ans;
    }
}