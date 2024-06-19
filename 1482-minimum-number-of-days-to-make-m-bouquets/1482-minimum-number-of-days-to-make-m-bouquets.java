class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        //this is question of binary search on answer 
        //we will pick mid as the ans for the no. of days in which we can make the bouqets and then we will see if we can reduce the ans
        int left = 0;
        int right = Integer.MIN_VALUE;
        int res = -1;
        
        //get the max of bloomDays as the max 
        for(int i : bloomDay){
            right = Math.max(right, i);
        }
        
        while(left<=right){
            //now get the mid
            int mid = (left + right)/2;

            int bouqetsMade = getBouqetMade(mid, bloomDay, k);

            if(bouqetsMade >= m){
                //then we can check for lower days as the ans and can store this as the potential answer
                res = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }     
        return res;    
    }
    
    private int getBouqetMade(int requiredDays, int[] bloomDay, int reqBloomedFlowers){
        int bloomCount = 0;
        int bouqetMade = 0;
        
        for(int day : bloomDay){
            if(day <= requiredDays){
                bloomCount++;
            }else{
                bloomCount = 0; //since we need adjacent days to create a bouqet
            }
            
            if(bloomCount==reqBloomedFlowers){
                bouqetMade++;
                //since one bouqet is created we have to make new bouqet so we need count to be re-initialised
                bloomCount = 0;
            }
        }
     return bouqetMade;   
    }
}