class Solution {
    public int minOperations(int[] nums, int k) {
        
        //if there is an element which is lesser than k then there is no result
        //result would be number of distinct integers greater than k since second largest will change largest integer & third largest will change the second largest and so on 
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num < k){
                return -1;
            }else if(num > k){
                set.add(num);
            }
        }
        return set.size();
    }
}