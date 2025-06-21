class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }

        int maxFreq = 0;
        List<Integer> freqList = new ArrayList<>();
        for(int f : freq){
            if(f > 0){
                freqList.add(f);
            }
            maxFreq = Math.max(maxFreq, f);
        }

        int minDeletions = Integer.MAX_VALUE;
        for(int target = 1; target<= maxFreq; target++){
            int deletions = 0;

            for(int f : freq){
                if(f < target){
                    deletions += f; //since if freq is lesser we can't increase freq to match target hence delete those many chars 
                }else if(f > target + k){
                    deletions += f - (target + k);
                } // else: in range, no deletion needed
            }

            minDeletions = Math.min(minDeletions, deletions);
        }
        return minDeletions;
    }
}
