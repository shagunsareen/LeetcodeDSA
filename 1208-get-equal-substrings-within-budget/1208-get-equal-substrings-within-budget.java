class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        int start = 0;
        int maxLen = 0;
        int currCost  = 0;
        
        for(int i=0; i<n; i++){
            
            currCost += Math.abs(s.charAt(i) - t.charAt(i)); //cost of converting chars at ith index 
            
            //if the cost exceeds maxCost then shrink window from left to decrease currCost
            while(currCost > maxCost){
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            
            //Length is maximum elements including currIndex - starting Index of the window
            maxLen =  Math.max(maxLen, i-start+1);
        }
        
        return maxLen;
    }
}