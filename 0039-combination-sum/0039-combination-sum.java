class Solution {
    
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtracking(0, target, candidates, new ArrayList<>());
        return result;
    }

    private void backtracking(int index, int target, int[] candidates, List<Integer> temp){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            int curr = candidates[i];
            temp.add(curr);
            backtracking(i, target-curr, candidates, temp);
            temp.remove(temp.size() - 1);
        }
    }
}