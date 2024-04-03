class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        ArrayList<Integer> subres = new ArrayList<>();
        permute(res, subres, nums);
        return res;
    }
    
    private void permute(List<List<Integer>> res, ArrayList<Integer> subres, int[] nums){
        int n = nums.length; 
        //Base condition
        if(subres.size() == n){
            res.add(new ArrayList<Integer>(subres));
            return;
        } 
        //take every element as first element 
        for(int i=0; i<n; i++){
            if(!subres.contains(nums[i])){
                subres.add(nums[i]);
                permute(res, subres, nums);
                subres.remove(subres.size() - 1); //remove last element inserted 
            }
        }
    }       
}