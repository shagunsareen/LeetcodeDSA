class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int r  = 0; //to keep lowest index in track 

        for(int j=0; j<n; j++){
            if(nums[j] == key){
                //check for indices matching 
                int l = Math.max(r, j-k); //we are starting with r because 
                int rNew = Math.min(n-1, j+k);  

                for(int i=l; i<=rNew; i++){
                    res.add(i); //this comes under valid range
                }
                r = rNew + 1; //to avoid duplicates since we have already included rNew 
            }
        }
        return res;
    }
}