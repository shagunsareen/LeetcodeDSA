class Solution {
    int totalWays = 0;
    public int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, target, 0, 0);
        return totalWays;
    }
    
    private void calculateWays(int[] num, int target, int currIndex, int currSum){
        //base case where to stop 
        if(currIndex == num.length){
            //check target
            if(currSum == target)
                totalWays++;
        }else{
           calculateWays(num, target, currIndex+1, currSum + num[currIndex]); //take positive integer
           calculateWays(num, target, currIndex+1, currSum - num[currIndex]); //take negative integer
        }
    }
}