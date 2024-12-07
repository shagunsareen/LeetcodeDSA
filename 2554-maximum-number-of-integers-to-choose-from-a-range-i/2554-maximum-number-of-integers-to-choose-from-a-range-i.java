class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int totalSum = 0;
        int count = 0;
        
        //store input elements in set to check later if that element exists or not
        Set<Integer> set = new HashSet<Integer>();
        for(int num : banned){
            set.add(num);
        }
        
        //check for 1 to n nums 
        for(int i=1; i<=n; i++){
            if(!set.contains(i) && (totalSum+i) <= maxSum){
                totalSum += i;  
                count++;
            }
        }
        
        return count;
    }
}