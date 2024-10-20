class Solution {
    public String gcdOfStrings(String str1, String str2) {     
        if(!(str1+str2).equals(str2+str1)){ //no GCD exists
            return "";
        }else{
            //if it exists then find the GCD string among them
            // if strings on combo are equal then GCDString should have length of GCD of both strings length
            int l1 = str1.length();
            int l2 = str2.length();
            
            return str1.substring(0, getGCD(l1, l2));
        } 
    }
    
    private int getGCD(int x, int y){
        if(y==0){
            return x;
        }else{
            return getGCD(y, x % y);
        }
    }
}