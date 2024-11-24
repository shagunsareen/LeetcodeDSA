class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int sPtr = 0;
        int tPtr = 0;
        int count = 0;
        
        while(tPtr < tLen && sPtr<sLen){
            if(s.charAt(sPtr) != t.charAt(tPtr)){
                tPtr++;
            }else{
                count++; //to check how many chars we got
                sPtr++;
                tPtr++;
            }
        }
        
        //check count 
        if(count == sLen){
            return true;
        }
        
        return false;
    }
}