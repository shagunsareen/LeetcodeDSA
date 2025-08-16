class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int first = 0;
        int second = 0;

        //insert key as number and value as index of key 
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int diff  = target - curr;

            if(map.containsKey(diff)){
                first = i;
                second = map.get(diff);
            }else{
                map.put(curr, i);
            }
        }

        return new int[]{first, second};
    }
}