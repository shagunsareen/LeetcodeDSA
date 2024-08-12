class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        ArrayList<Integer> currentList = new ArrayList<>();
        getCombinationSum(currentList, candidates, target, 0);
        return result;
    }
    
    private void getCombinationSum(ArrayList<Integer> currentList, int[] candidates, int target, int index){    
        if(target == 0)
        {
            result.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i=index; i<candidates.length; i++){
            int currVal = candidates[i];
            if(currVal<=target){
                currentList.add(currVal);
                getCombinationSum(currentList, candidates, target-currVal, i); //same index because we can take a number multiple times
                currentList.remove(currentList.size() - 1);
            }     
        }
    }
}