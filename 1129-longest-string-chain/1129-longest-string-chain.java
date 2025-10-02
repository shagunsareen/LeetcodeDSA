class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        Arrays.sort(words, (a,b) -> a.length() - b.length());

        int max = 1; //as per constraints atleast 1 is size

        //at every index keep length of longest string chain till this index word 
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(checkPossible(words[i], words[j]) && (dp[i] < 1 + dp[j])){
                    dp[i] = 1 + dp[j];
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }

    private boolean checkPossible(String word1, String word2){ //word1 is longer as its current one and word2 is shorter as its previous word from sorted words array
        int l1 = word1.length();
        int l2 = word2.length();

        //both lengths should diff by 1 
        if(l1 != l2 + 1){
            return false;
        }
        
        int first = 0;
        int second = 0;

        while(first < l1){
            if(second < l2 && word1.charAt(first) == word2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        //if we are able to exhaust l1 and l2 both 
        return first == l1 && second == l2;
    }
}