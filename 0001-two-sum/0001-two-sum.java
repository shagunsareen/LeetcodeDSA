class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int first = -1;
        int second = -1;

        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int find = target - curr;

            if(map.containsKey(find)){
                first = i;
                second = map.get(find);
                break;
            }
            map.put(curr, i);
        }

        return new int[]{first, second};
    }
}