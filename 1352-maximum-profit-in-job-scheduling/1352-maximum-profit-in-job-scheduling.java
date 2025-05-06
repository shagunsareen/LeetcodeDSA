class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        //Step 1. we should sort by start time since we want lesser time to begin first 
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        //store jobs info in one array
        for(int i=0; i<n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[n]; //we will store at each job index what is the max profit we can make
        Arrays.fill(dp, -1);

        return dfs(jobs, dp, 0, n); //starting with 0th index  
    }

    
    private int dfs(int[][] jobs, int[] dp, int index, int n){
        if(index >= n) return 0;

        if(dp[index] != -1) return dp[index];

        //skip the job 
        int skipP = dfs(jobs, dp, index + 1, n); 
        //take the job
        int takeP = jobs[index][2] + dfs(jobs, dp, getNextJobIndex(index + 1, n-1, jobs), n);
        //profit would be max(skip , take)

        dp[index] = Math.max(skipP, takeP);

        return dp[index];
    }

    //binary search should start from curr index + 1 pos to end of the array
    private int getNextJobIndex(int start, int end, int[][] jobs){
        int ans  = end + 1; //since we have in line 24 the profit as 0 if index is out of bounds
        int currEndTime = jobs[start-1][1];

        while(start <= end){
            int mid = (start + end)/2;

            if(jobs[mid][0] >= currEndTime){ //next start time >= curr end time
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}