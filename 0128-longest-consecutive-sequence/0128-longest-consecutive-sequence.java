class Solution {
    public int longestConsecutive(int[] nums) {
        /* Approach 1 - tc : O(nlogn)
        
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        Arrays.sort(nums);

        //there can be duplicates
        
        int i=1;
        int count = 1;
        int maxCount = 1;

        while(i<n){
            //skip all duplicates
            while(i < n && nums[i] == nums[i-1]){
                i++;
            }

            if(i >=n ) break;

            if(nums[i] == nums[i-1] + 1){
                count++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 1; //reset the count
            }
            i++;
        }

        return Math.max(maxCount, count);
        */

        //Approach 2 - Using hashset 
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums)
        {
            set.add(num);
        }

        int length = 0;
        int maxLength = 0;

        //check if num is the start num of subsequence that is we dont have any number before this
        for(int num : set)
        {
            if(!set.contains(num-1)){ //this num is start of sequence, go check longest length starting for this sequence
                length = 1;
                while(set.contains(num + 1)){
                    length++;
                    num++;
                }
                maxLength = Math.max(length, maxLength);
            }   
        }
        return maxLength;
    }
}