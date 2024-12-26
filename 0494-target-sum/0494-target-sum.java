class Solution {
    
    
    //Approach 1 : Recursion 
    /*int totalWays = 0;
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
    }*/
    
    
    //Approach 2 : Recursion with Memoization 
    /*int totalSum;
    public int findTargetSumWays(int[] nums, int target) {  
        totalSum = Arrays.stream(nums).sum();
        
        int[][] memo = new int[nums.length][2*totalSum + 1];
        for(int[] row : memo){
            Arrays.fill(row, Integer.MIN_VALUE);
        } 
        
        return calculateTotalWays(nums, target, 0, 0, memo);
    }
    
    private int calculateTotalWays(int[] nums, int target, int currIndex, int currSum, int[][] memo)
    {
          //base case if we have reached end index
          if(currIndex == nums.length){
              if(currSum == target){
                  return 1;
              }else{
                  return 0;
              }
          }else{
              //check if the result is already computed 
              if(memo[currIndex][currSum + totalSum] != Integer.MIN_VALUE){
                  return memo[currIndex][currSum + totalSum];
              }
              
              //include the positive of the current number
              int add = calculateTotalWays(nums, currIndex + 1, currSum + nums[currIndex], target, memo);
              
              // include the negative of the current number 
              int subtract = calculateTotalWays(nums, currIndex + 1, currSum - nums[currIndex], target, memo);
              
              //Store the result in the memoization table
              memo[currIndex][currSum + totalSum] = add + subtract;  
              return memo[currIndex][currSum + totalSum];
          }
    }*/

    // Sum of all elements in the array
    int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculateWays(nums, 0, 0, target, memo);
    }

    private int calculateWays(
        int[] nums,
        int currentIndex,
        int currentSum,
        int target,
        int[][] memo
    ) {
        if (currentIndex == nums.length) {
            // Check if the current sum matches the target
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            // Check if the result is already computed
            if (
                memo[currentIndex][currentSum + totalSum] != Integer.MIN_VALUE
            ) {
                return memo[currentIndex][currentSum + totalSum];
            }
            // Calculate ways by adding the current number
            int add = calculateWays(
                nums,
                currentIndex + 1,
                currentSum + nums[currentIndex],
                target,
                memo
            );

            // Calculate ways by subtracting the current number
            int subtract = calculateWays(
                nums,
                currentIndex + 1,
                currentSum - nums[currentIndex],
                target,
                memo
            );

            // Store the result in memoization table
            memo[currentIndex][currentSum + totalSum] = add + subtract;

            return memo[currentIndex][currentSum + totalSum];
        }
    }
}