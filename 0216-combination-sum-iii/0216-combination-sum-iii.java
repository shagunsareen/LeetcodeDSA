class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        ArrayList<Integer> currentList = new ArrayList<>();
        getCombination(currentList, k, n, 1);
        return result;
    }
    
    private void getCombination(ArrayList<Integer> currentList, int k, int sum, int index){
        //base case 
        if(k==0 && sum==0){
            result.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i=index; i<=9; i++){   
            if(i <= sum){
                currentList.add(i);
                getCombination(currentList, k-1, sum-i, i+1);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}