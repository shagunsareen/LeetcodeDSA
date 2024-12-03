class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        //Approach : TC:O(n), SC:O(n)
        /*String[] words = sentence.split(" ");
        int searchWLen = searchWord.length();
        
        for(int i=0; i<words.length; i++){
            int currWLen = words[i].length();
            
            if(!(searchWLen > currWLen) && words[i].substring(0, searchWLen).equals(searchWord)){
                return i+1;
            }
        }
        
        return -1;*/
        
        //Approach : TC:O(n), SC:O(1)
        int strPtr = 0;
        int wordIndex = 1;
        
        //check if str char is same as word char 
        while(strPtr < sentence.length())
        {
            if(strPtr == 0 || sentence.charAt(strPtr-1) == ' ')
            {   //check for only starting indexes and then move forward
                //int tmpPtr = strPtr;
                int wordPtr = 0;
                int matchedCharCount = 0;

                while(wordPtr < searchWord.length() && strPtr < sentence.length() && sentence.charAt(strPtr) == searchWord.charAt(wordPtr))
                {
                    wordPtr++;
                    strPtr++;
                    //tmpPtr++;
                    matchedCharCount++;

                    if(matchedCharCount == searchWord.length()){
                        return wordIndex;
                    }
                } 
            }
            
            if(strPtr < sentence.length() && sentence.charAt(strPtr) == ' '){
                wordIndex++;
            }
            
            strPtr++;      
        }
        
        return -1;
    }
}