class Solution {
    /*public int countSubstrings(String s) {
        int ans = 0;

        //consider all chars as the center of substring
        //consider odd and even length substrings
        for(int i=0; i<s.length(); i++){
            ans += countPalindrome(s, i, i);
            ans += countPalindrome(s, i, i+1);
        }
        return ans;
    }

    private int countPalindrome(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }*/

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        //single length substrings
        for(int i = 0; i < n; i++)
        {
            dp[i][i] = true;
            ans++;
        }

        //Two length substrings
        for(int i = 0; i < n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                ans++;
            }
        }

        //all other length substrings
        for(int diff = 2; diff < n; diff++){
            for(int i = 0; i < n-diff; i++){
                int j = i + diff;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}