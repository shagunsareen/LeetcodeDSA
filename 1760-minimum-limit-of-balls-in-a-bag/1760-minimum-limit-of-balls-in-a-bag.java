class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        //this question is binary search on ans i.e. we need to find maxBallsInBag and we have to minimize the value
        // to minimize the value we need to know all possible answers and since the range is sorted we can get possible answers by doing binary search.
        // we pick one value and we check whether maxBallsInBag is possible or not or can we get lower value
        int left = 1;
        int right = 0;
        
        for(int n : nums){
            right = Math.max(n, right);
        }
        
        while(left < right){
            int mid = (left + right)/2;
            
            //check if these many balls are possible then reduce the search range 
            if(isPossible(mid, nums, maxOperations)){
                right = mid; //we will store possible ans in right variable
            }else{
                //move to right to search for the ans
                left = mid + 1;
            }
        }
        
        return right;  //we come out of the loop either when left > right in which case we return last right value or when left == right then we can return any value 
    }
    
    
    private boolean isPossible(int maxBalls, int[] nums, int maxOperations){  
        //check if maxBalls can be the max no. of balls in the entire array with maxOperations
        //to keep check on operations used have totalOp variable
        int totalOp = 0;
        
        for(int n : nums){
            //check if we can divide the curr element into maxBalls 
            int operations = (int)Math.ceil(n/(double)maxBalls)-1;
            totalOp += operations;
            
            if(totalOp > maxOperations){
                return false;
            }
        }
        
        return true;
    }
    
}




