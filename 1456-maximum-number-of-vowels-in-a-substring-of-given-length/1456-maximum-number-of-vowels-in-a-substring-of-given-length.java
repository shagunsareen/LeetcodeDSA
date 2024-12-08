class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        
        //traverse first window of size k 
        for(int i=0; i<k; i++){
            char curr = s.charAt(i);
            if(isVowel(curr)){
                count++;
            }
        }
        
        int maxCount = count;
        
        //traverse rest of the string
        int start = 0;
        int end = k;
        
        while(end < s.length()){      
            //check if start char was vowel and reduce count if yes
            char prev = s.charAt(start);
            if(isVowel(prev)){
                count--;
            }
            
            //check if upcoming char is vowel and increase the count if yes
            char next = s.charAt(end);
            if(isVowel(next)){
                count++;
            }
            
            maxCount = Math.max(maxCount, count);
            
            start++;
            end++;
        }
        return maxCount;
    }
    
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}