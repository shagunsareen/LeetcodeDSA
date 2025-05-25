class Solution {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        while(start <= end && end < n){
            char curr = s.charAt(end);
            if(set.contains(curr)){ //duplicate
                maxLength = Math.max(maxLength, end - start);
                while(set.contains(curr)){
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(curr);
            end++;
        }

        maxLength = Math.max(maxLength, end - start);
        
        return maxLength;
    }
}