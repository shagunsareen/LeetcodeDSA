class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n == 1){
            return s;
        }

        String maxStr = s.substring(0, 1);

        //we check for even palindrome and odd palindrome for each character 
        for(int i=0; i<n; i++){

            //even palindromes for this character
            String evenStr = checkPalindrome(s, i, i+1);

            String oddStr = checkPalindrome(s, i, i);

           if(oddStr.length() > maxStr.length()){
             maxStr = oddStr;
           }
           if(evenStr.length() > maxStr.length()){
             maxStr = evenStr;
           }
        }

        return maxStr;
    }

    private String checkPalindrome(String s, int left, int right){

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}