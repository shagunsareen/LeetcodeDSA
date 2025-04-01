class Solution {
    //since this can't be done in n2 because of constraints if we will keep on iteration both choices then TC will be 2^N which will give TLE
    long[] dp;
    public long mostPoints(int[][] questions) {
        // for every question index we need to store precomputed value
        dp = new long[questions.length]; 
        Arrays.fill(dp, -1);
        return getMaxPoints(questions, 0);
    }

    private long getMaxPoints(int[][] questions, int index){
        int n = questions.length;

        if(index >= n){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        //either we can take curr element 
        long include = questions[index][0] + getMaxPoints(questions, index + questions[index][1] + 1); //skipping elements and taking next element from the array

        //or we can skip the curr element
        long exclude = getMaxPoints(questions, index + 1); 
        
        dp[index] = Math.max(exclude, include);

        return dp[index];
    }


}