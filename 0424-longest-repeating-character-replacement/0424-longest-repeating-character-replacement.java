class Solution {
    public int characterReplacement(String s, int k) {
        
        //we need to find longest substring length which means we need to find longest window which is valid 
        //a window is valid when we are able to convert chars with utmost k's so we see what is length of current window and how many chars we need to convert if it fits k then take maxlength else shrink window from left and update start character frequency
        //keep freq in int[26]

        /*int left = 0;
        int maxLength = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        //we iterate each char with right pointer and shrink window with left pointer
        for(int right = 0; right < s.length(); right++){

            char curr = s.charAt(right);
            freq[curr - 'A']++; 
            maxFreq = Math.max(maxFreq, freq[curr - 'A']); //max freq in window yet

            boolean isValidWindow = (right - left + 1 - maxFreq <= k);
            if(!isValidWindow){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; */

        int[] freq = new int[26];
        int start = 0;
        int n = s.length();
        int maxLength = 0;
        int maxFreq = 0;

        for(int end = 0; end < n; end++){
            char ch = s.charAt(end);
            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            int windowSize = end - start + 1;
            int changesRequired = windowSize - maxFreq;
            boolean isWindowValid = (changesRequired <= k);

            if(!isWindowValid){
                //move left pointer to right by 1 step 
                freq[s.charAt(start) - 'A']--;
                start++;
                windowSize--;
            }

            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
}