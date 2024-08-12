class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        ArrayList<Integer> currentList = new ArrayList<>();
        getCombinations(currentList, n , k, 1);
        return result;
    }
    
    private void getCombinations(ArrayList<Integer> currentList, int n, int countToUse, int index){
        if(countToUse==0){
            result.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i=index; i<=n; i++){
            currentList.add(i);
            getCombinations(currentList, n, countToUse-1, i+1);
            currentList.remove(currentList.size()-1);
        }
    }
}