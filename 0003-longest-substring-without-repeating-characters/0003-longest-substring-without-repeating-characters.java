class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0; //fix this ans reset on finding duplicate
        int end = 0;
        int maxLength = 0;
        int n = s.length();

        while(end < n){
            char curr = s.charAt(end);
            while(set.contains(curr)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(curr);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
}