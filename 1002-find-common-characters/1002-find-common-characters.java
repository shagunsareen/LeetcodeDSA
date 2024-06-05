class Solution {
    public List<String> commonChars(String[] words) {
        
        //store the frequency of each char in first word in an array of size 26 since we only have lowercase characters
        int[] commonCharCount = new int[26];
        
        for(char ch : words[0].toCharArray()){
            commonCharCount[ch-'a']++;
        }
        
        int[] currentCharCount = new int[26];
        for(int i=1; i<words.length; i++){
            Arrays.fill(currentCharCount, 0); //this is to reset the values for the new word
            
            //count freq in the current word
            for(char ch : words[i].toCharArray()){
                currentCharCount[ch-'a']++;
            }
            
            //keep the minimum frequency out of both the words
            for(int letter=0; letter<26; letter++){
                commonCharCount[letter] = Math.min(commonCharCount[letter], currentCharCount[letter]);
            }
        }
        
        
        //now convert this into final result 
        List<String> resList = new ArrayList<>();
        for(int letter=0; letter<26; letter++){
            //store the number of times as the frequency of the character
            while(commonCharCount[letter] > 0){
                resList.add(String.valueOf((char)(letter + 'a')));
                commonCharCount[letter]--;
            }
        }
        return resList;
    }
}