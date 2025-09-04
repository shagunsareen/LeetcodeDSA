class Solution {

    //Approach 1 - Tabulation , Iterative, Bottom to Up
    public int minCostClimbingStairs(int[] cost) {
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
}