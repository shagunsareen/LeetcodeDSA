class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;

        while(left < right){
            //check if curr ele at left and right is nonAlphaNum then skip it 
            while(left < right && !isAlphaNum(s.charAt(left))){
                left++;
            }

            while(left < right && !isAlphaNum(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNum(char ch){
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}