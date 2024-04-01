class Solution {
    public int lengthOfLastWord(String s) {
        
        /* Error : TLE
        int i=0;
        int n=s.length();
        int strLength = 0;
        int lastSpaceIndex = 0;
        
        while(i<n){
            if(s.charAt(i) != ' '){
                i++;
            }else{
                strLength = i - lastSpaceIndex;
                lastSpaceIndex = i;
            }
        }
        
        return strLength;
        */
        
        //Method 2 
        String[] strArr = s.split(" ");
        String lastString = strArr[strArr.length - 1];
        return lastString.length();
    }
}