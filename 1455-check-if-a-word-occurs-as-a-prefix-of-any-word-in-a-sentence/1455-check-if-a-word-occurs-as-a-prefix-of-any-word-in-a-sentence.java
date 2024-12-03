class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int searchWLen = searchWord.length();
        
        for(int i=0; i<words.length; i++){
            int currWLen = words[i].length();
            
            if(!(searchWLen > currWLen) && words[i].substring(0, searchWLen).equals(searchWord)){
                return i+1;
            }
        }
        
        return -1;
    }
}