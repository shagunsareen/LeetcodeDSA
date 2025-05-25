class Solution {
    public int longestPalindrome(String[] words) {
         int[][] freq = new int[26][26];
        int palindromeCount = 0;
        int midCount = 0;
        
        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            if (freq[b][a] > 0) {
                palindromeCount += 4;
                freq[b][a]--;
                if (a == b) {
                    midCount--;
                }
            } else {
                freq[a][b]++;
                if (a == b) {
                    midCount++;
                }
            }
        }
        
        if (midCount > 0) {
            palindromeCount += 2;
        }
        return palindromeCount;
    }
}