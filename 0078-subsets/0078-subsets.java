class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        res = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        generateSubset(nums, currList, res, 0, n);
        return res;
    }
    
    
    private void generateSubset(int[] nums, 
                                ArrayList<Integer> currList,
                                List<List<Integer>> res, 
                                int startIndex, 
                                int size)
    {    
        res.add(new ArrayList<>(currList)); 
        
        for(int i=startIndex; i<size; i++){ 
            //take the current element 
            currList.add(nums[i]);   
            //recursively see if you want to take next element or not
            generateSubset(nums, currList, res, i+1, size);   
            // do not take the last added element 
            currList.remove(currList.size() - 1);
        }
    }
}