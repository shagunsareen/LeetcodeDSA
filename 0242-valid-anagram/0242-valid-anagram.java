class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int[] tCount = new int[26];
        int[] sCount = new int[26];

        if(sLen != tLen){
            return false;
        }
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            sCount[ch - 'a']++;
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            tCount[ch - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(sCount[i] != tCount[i]){
                return false;
            }
        }

        return true;
    }
}