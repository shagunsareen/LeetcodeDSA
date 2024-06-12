class Solution {
    public void sortColors(int[] nums) {
        
        int start = 0;
        int end = nums.length-1;
        int ptr = 0;

     while(ptr<=end){
         if(nums[ptr]==2){
            //move this to the end
            int temp = nums[end];
            nums[end] = nums[ptr];
            nums[ptr] = temp;
            end--;
        }else if(nums[ptr]==0){
            //move this to the start
            int temp = nums[start];
            nums[start] = nums[ptr];
            nums[ptr] = temp;
            start++;
            ptr++;
        }else{//if it is 1
            ptr++;
        }
       //System.out.println("Start : "+start+ " - , Mid : "+ptr+", - End : "+end);
     }
    }   
}