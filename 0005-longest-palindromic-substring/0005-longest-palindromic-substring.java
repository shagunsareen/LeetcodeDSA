class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        
        //Expand outward center approach 
        //Consider each character as the center of the subtring and expand outwards if the characters match 
        //For every char we will check oddPlindrome and evenPalindrome 
        String maxStr = s.substring(0,1);
        
        for(int i=0; i<s.length(); i++){
            
            //consider the current element only 
            String oddStr = expandAroundCenter(s, i, i);  //this will give the length of the palindromic string
            
            //consider current element and neighbouring element
            String evenStr = expandAroundCenter(s, i, i+1);
            
            if(oddStr.length() > maxStr.length())
                maxStr = oddStr;
            
            if(evenStr.length() > maxStr.length())
                maxStr = evenStr;
        }
        
        return maxStr;
    }
    
    
    private String expandAroundCenter(String str, int left, int right){
        
        while(left >= 0 && right <= str.length()-1 && str.charAt(left) == str.charAt(right)){
            left--;
            right++; //if characters match lets explore more on both ends
        } 
        return str.substring(left+1, right);  
        //since left and right will be incremented and will go out of bounds hence increment left and decrement right will be done automatically by subtring function as it considers second param index -1;
    }
}