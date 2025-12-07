class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(int index, List<Integer> temp, int[] nums){
        result.add(new ArrayList<>(temp));
        
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(i+1, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}