class Solution {
    private static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        //store freq of each character 
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        //t iterations 
        for(int i=0; i<t; i++){
            //each transformation will give new freq count
            int[] next = new int[26];
            for(int j=0; j<26; j++){
                //if char is z i.e. index is 25 then handle is separately
                if(j < 25){
                    //update next characters frequency
                    next[j+1] = freq[j];
                }else{
                    next[0] = freq[j];
                    next[1] = (freq[0] + freq[25]) % MOD;
                }
            }

            freq = next;
        }

        //now check count of chars after final iteration
        int ans = 0;
        for(int i=0; i<26; i++){
            ans = (ans + freq[i]) % MOD;
        }

        return ans;
    }
}