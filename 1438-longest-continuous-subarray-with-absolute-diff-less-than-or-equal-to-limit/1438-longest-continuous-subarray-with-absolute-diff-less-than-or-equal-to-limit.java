class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //we use 2 dequeus and sliding window to get the longest subarray 
        Deque<Integer> inc = new LinkedList<>();
        Deque<Integer> dec = new LinkedList<>();
        
        int maxLength = 0;
        int left = 0;
        
        //i == right
        for(int i=0; i<nums.length; i++){
            
            //check the current element
            int curr = nums[i];
            
            //remove greater elements from inc queue
            while(!inc.isEmpty() && inc.getLast() > curr){
                inc.removeLast();
            }
            inc.add(curr);
            
            //remove smaller elements from dec queue
            while(!dec.isEmpty() && dec.getLast() < curr){
                dec.removeLast();
            }
            
            dec.add(curr);
            
            //now check in this window max and the min elements and see if the differene is withing the limit or not
            while((dec.getFirst() - inc.getFirst()) > limit){
                //remove curr element from inc and dec queue
                if(nums[left] == dec.getFirst()){
                    dec.removeFirst();
                }
                
                if(nums[left] == inc.getFirst()){
                    inc.removeFirst();
                }
                //can't include curr element since diff is exceeding limit
                left++; 
            }
            
            //if it is out of while means it is withing the limit hence calculate the length of the window
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength; 
    }
}