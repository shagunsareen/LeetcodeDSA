class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;

        String maxStr = s.substring(0,1);

        //expand outwards from center approach
        //consider odd and even length strings and check if palindrome
        for(int i=0; i<s.length(); i++){

            String oddStr = expand(s, i, i); 
            String evenStr = expand(s, i, i+1);

            if(oddStr.length() > maxStr.length()){
                maxStr = oddStr;
            }

            if(evenStr.length() > maxStr.length()){
                maxStr = evenStr;
            }
        }

        return maxStr;
    }

    private String expand(String str, int left, int right){
        while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return str.substring(left+1, right); //since we need to include only 
    }
}