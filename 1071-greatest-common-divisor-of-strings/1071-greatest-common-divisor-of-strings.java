class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //check whether both string additions are equal or not        
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }else{
            int gcd = getGCD(str1.length() , str2.length());
            return str1.substring(0, gcd);
        }
    }
    
    private int getGCD(int x, int y)
    {
        if(y==0){ 
            return x; 
        }
        else{
            return getGCD(y,x%y); 
        }
    }
}