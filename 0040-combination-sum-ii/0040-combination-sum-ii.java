class Solution {
    List<List<Integer>> resList;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //To get the combinations we will have to store it in resultant list 
         resList = new ArrayList<>();
         Arrays.sort(candidates);
         generateCombinationSum(resList, new ArrayList<Integer>(), target, candidates, 0);
         return resList;
    }

    private void generateCombinationSum(List<List<Integer>> resList, 
                                        ArrayList<Integer> currList, 
                                        int target, 
                                        int[] candidates, 
                                        int index)
    {
        if(target < 0){
            return;
        }
        
        //check if the target is met
        if(target == 0){
            //add curr combo to result 
            if(!resList.contains(currList)){
                System.out.println(currList.toString());
                resList.add(new ArrayList<Integer>(currList));
                return; 
            } 
        }

        //select each element multiple times 
        for(int i=index; i<candidates.length; i++){
           if(i > index && candidates[i] == candidates[i-1]) { //This is to skip duplicates -- we can take each element while generating sequences for i = index but if are have 1,1,1 then generating sequences for second 1 is same as that of first 1 hence don't call recursive function for those elements and skip those
                continue;
            }
            currList.add(candidates[i]); //add the current element                                     
            generateCombinationSum(resList, currList,target-candidates[i], candidates, i+1);
            currList.remove(currList.size()-1);
        } 
    }
}