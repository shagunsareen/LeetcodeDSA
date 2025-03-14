class Solution {
    public int maximumCandies(int[] candies, long k) { 
        //find max candies as search will be within that range then
        int maxCandies = 0;
        for(int candi : candies){
            maxCandies = Math.max(maxCandies, candi);
        }

        //now binary search would be on ans as we will check if we get mid i.e. we distribute mid candies to every children is it going to work
        int left = 1;
        int right = maxCandies;
        int ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            //check whether this mid is feasible or not
            if(canAllocateCandies(candies, k, mid)){
                ans = mid; //potential answer but we need to maximize ans so we will explore more on the right 
                left = mid + 1; 
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAllocateCandies(int[] candies, long childToServe, int numCandies){
        //we will calculate maxChildren that can be served then we will see whether max is equal or greater than childCount and we return true if it is
        long maxChildServed = 0;

        for(int pileIndex = 0; pileIndex < candies.length; pileIndex++){
            maxChildServed += candies[pileIndex]/numCandies; 
            //this gives how many children can get those many candies
        }
        return maxChildServed >= childToServe;
    }
}