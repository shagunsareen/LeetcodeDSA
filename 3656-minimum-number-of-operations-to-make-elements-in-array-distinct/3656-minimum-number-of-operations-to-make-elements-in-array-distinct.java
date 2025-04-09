class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int minOp = 0;
        for(int i=0; i<n; i+=3){   
            if(checkDistinct(nums, i)){
                return minOp;
            }  
            minOp++;
        }
        return minOp;
    }

    private boolean checkDistinct(int[] nums, int start){
        //put elements in set and check if all are unique
        HashSet<Integer> set = new HashSet<>();

        for(int index = start; index < nums.length; index++){
            set.add(nums[index]);
        }

        return set.size() == (nums.length - start); //if all elements are unique
    }
}