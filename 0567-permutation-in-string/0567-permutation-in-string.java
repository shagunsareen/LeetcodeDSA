class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 > l2) return false;

        //get freq of chars in s1 
        int[] s1Freq = new int[26];
        int[] window = new int[26];

        for(char ch : s1.toCharArray()){
            s1Freq[ch - 'a']++;
        }

        //any window of size s1 should have same freq array then we return true
        int k = l1;
        int start = 0;

        for(int end = 0; end < s2.length(); end++){
            
            char ch = s2.charAt(end);
            window[ch - 'a']++;

            if(end - start + 1 > k){ //shrink window
                window[s2.charAt(start) - 'a']--;
                start++;
            }

            if(end - start + 1 == k){
                if(matches(s1Freq, window)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matches(int[] arr1, int[] arr2){
        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}