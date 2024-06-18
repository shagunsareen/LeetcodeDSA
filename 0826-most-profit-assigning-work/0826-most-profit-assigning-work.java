class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> jobProfile = new ArrayList<>();
        jobProfile.add(new int[]{0,0});
        
        for(int i=0; i<difficulty.length; i++){
            jobProfile.add(new int[]{ difficulty[i], profit[i]});
        }
        
        
        Arrays.sort(worker);
        Collections.sort(jobProfile, (a,b) -> Integer.compare(a[0],b[0]));
        // Update the job profiles to ensure each difficulty has the maximum profit up to that difficulty
        for (int i = 1; i < jobProfile.size(); i++) {
            jobProfile.get(i)[1] = Math.max(jobProfile.get(i)[1], jobProfile.get(i - 1)[1]);
        }
        
        int netProfit = 0;
        
        //find the max profit for each worker hence apply binary search
        for(int i=0; i<worker.length; i++){
            int ability = worker[i];
            
            //we have to see at what index we can achieve this ability
            int l = 0;
            int r = jobProfile.size()-1;
            int jobProfit = 0;
            
            while(l<=r){
                int mid = (l+r)/2;
                
                if(ability < jobProfile.get(mid)[0]){
                    r = mid-1;
                }else {
                    jobProfit = Math.max(jobProfit, jobProfile.get(mid)[1]);
                    l = mid+1;
                }
            }
            
            netProfit +=  jobProfit;
        }
        return netProfit;
    }
}