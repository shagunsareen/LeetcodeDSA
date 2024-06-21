class Solution {
    public int maxDistance(int[] position, int m) {
        //this is binary search on answer
        Arrays.sort(position);
        int low = 0;
        int high = position[position.length-1];
        int ans = 0;
        
        while(low<=high){
            int mid = (low + high)/2;
            
            if(isPlacementPossible(position, m , mid)){
                ans = mid;
                //since we have to maximize the ans we will increase the low 
                low = mid+1;
            }else{
                high = mid-1;
            }
        } 
       return ans;
    }
    
    
    private boolean isPlacementPossible(int[] position, int m, int mid){
        //we have to check whether the max distance we have passed as input will place all the balls or not
        int count = 1; //since first ball we will place at 0th index anyway
        int last = position[0];
        for(int i=0; i<position.length; i++){
            //check the distance between the 2 points and if it is greater or equal to the decided value 
            if(position[i] - last >= mid){
                count++;
                last = position[i];
            }
        }
        return count >=m; //if we are able to place all the balls in the decided distance then return true
    }
}