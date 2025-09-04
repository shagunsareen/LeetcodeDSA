class Solution {

    //Approach 1 - Tabulation , Iterative, Bottom to Up
  /*  public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int minCost[] = new int[n + 1]; 
        minCost[0] = 0;
        minCost[1] = 0;

        for(int i=2; i < minCost.length; i++){
            int oneStepCost = minCost[i-1] + cost[i-1];
            int twoStepCost = minCost[i-2] + cost[i-2];
            minCost[i] = Math.min(oneStepCost, twoStepCost); 
        }

        return minCost[minCost.length -1];
    }

    //Approach 2 - Top Down , Recursive, Memoization
    Map<Integer, Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {   
      int n = cost.length;
      return minCost(n, cost); //we start from top value and store values calculated on the way to reach bottom indexes 
    }

    private int minCost(int step, int[] cost){
        if(step <= 1){
            return 0; //since we can start from both and mincost for starting point will be 0
        }

        if(map.containsKey(step)){
            return map.get(step);
        }

        int oneStepCost = minCost(step - 1, cost) + cost[step-1];
        int twoStepCost = minCost(step - 2, cost) + cost[step-2];
        int value = Math.min(oneStepCost, twoStepCost);
        map.put(step, value);

        return value;
    } */

    //Approach 3 - No extra space 
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int minCostOne = 0;
        int minCostTwo = 0;

        for(int i=2; i < cost.length + 1; i++){
            int temp = minCostOne;
            minCostOne = Math.min(minCostOne + cost[i-1], minCostTwo + cost[i-2]); 
            minCostTwo = temp;
        }

        return minCostOne;
    }
}