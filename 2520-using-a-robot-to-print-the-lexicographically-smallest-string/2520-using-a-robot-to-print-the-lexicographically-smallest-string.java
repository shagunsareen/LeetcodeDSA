import java.util.*;

class Solution {
    private char smallest(int[] rightFreq) {
        for (int i = 0; i < 26; ++i) {
            if (rightFreq[i] > 0)
                return (char) ('a' + i);
        }
        return 'z';
    }

    public String robotWithString(String s) {
        int n = s.length();
        int[] rightFreq = new int[26];
        for (int i = 0; i < n; ++i) {
            rightFreq[s.charAt(i) - 'a']++;
        }

        StringBuilder t = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int pos = 0;
        while (pos < n) {
            t.append(s.charAt(pos));
            rightFreq[s.charAt(pos) - 'a']--;

            while (t.length() > 0 && t.charAt(t.length() - 1) <= smallest(rightFreq)) {
                res.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
            pos++;
        }
        return res.toString();
    }
}