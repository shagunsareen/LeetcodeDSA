class Solution {
    /*List<List<Integer>> subsets;
    public int subsetXORSum(int[] nums) {  
        //generate all subsets
        subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>());

        //get the XOR value 
        int result = 0;
        for(List<Integer> subset : subsets){
            int subsetXORTotal = 0;
            for(int num : subset){
                subsetXORTotal ^= num;
            }

            result += subsetXORTotal;
        }

        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> currList){
        if(index == nums.length){
            subsets.add(new ArrayList<>(currList));
            return;
        }
        //DO
        currList.add(nums[index]);
        generateSubsets(nums, index+1, currList);
        
        //UNDO
        currList.remove(currList.size()-1);
        generateSubsets(nums, index+1, currList);
    }*/

    //Approach 2
    public int subsetXORSum(int[] nums) {  
        return getXORSum(nums, 0, 0);
    }

    private int getXORSum(int[] nums, int index, int currentXOR){
        if(index == nums.length){
            return currentXOR;
        }

        int withElementXORSum = getXORSum(nums, index + 1, currentXOR^nums[index]);

        int withoutElementXORSum = getXORSum(nums, index + 1, currentXOR);

        return withElementXORSum + withoutElementXORSum;
    }
}