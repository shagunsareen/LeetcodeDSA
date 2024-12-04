class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        int l1 = str1.length();
        int l2 = str2.length();
        int i=0;
        int j=0;
        
        while(i<l1 && j <l2){
            
            //compare both chars and see if on incremeent/decrement they match
            if(str1.charAt(i) == str2.charAt(j)
               || str1.charAt(i) + 1 == str2.charAt(j)
               || str1.charAt(i) - 25 == str2.charAt(j))
            {
                j++;
            }
            
            if(j==l2){
                return true;
            }
            
            i++;
        }
        
        return false;
    }
}