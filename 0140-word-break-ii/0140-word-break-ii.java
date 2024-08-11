class Solution {

    /*public List<String> wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> results = new ArrayList<>();
        // Start the backtracking process
        backtrack(s, wordSet, new StringBuilder(), results, 0);
        return results;
    }

    private void backtrack(
        String s,
        Set<String> wordSet,
        StringBuilder currentSentence,
        List<String> results,
        int startIndex
    ) {
        // If we've reached the end of the string, add the current sentence to results
        if (startIndex == s.length()) {
            results.add(currentSentence.toString().trim());
            return;
        }

        // Iterate over possible end indices
        for (
            int endIndex = startIndex + 1;
            endIndex <= s.length();
            endIndex++
        ) {
            String word = s.substring(startIndex, endIndex);
            // If the word is in the set, proceed with backtracking
            if (wordSet.contains(word)) {
                int currentLength = currentSentence.length();
                currentSentence.append(word).append(" ");
                // Recursively call backtrack with the new end index
                backtrack(s, wordSet, currentSentence, results, endIndex);
                // Reset currentSentence to its original length
                currentSentence.setLength(currentLength);
            }
        }
    }*/
    
    //Approach 1 : Backtracking , TC :O(2 power n), SC :O(2 power n)
    //since here 2 variables are changing hence memoization can't be done.
    /*List<String> result;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        StringBuilder currentSentence = new StringBuilder();
        backtrack(s, new HashSet<String>(wordDict), currentSentence, 0);
        return result;
    }
    
     private void backtrack(
        String s,
        Set<String> wordSet,
        StringBuilder currentSentence,
        int startIndex
    ){
         //base case 
         if(startIndex == s.length()){
             result.add(currentSentence.toString().trim());
             return;
         }
         
         //fix the end index of substring to check whether it is in set or we have to move forward
         for(int end = startIndex + 1; end<=s.length(); end++){
            String word = s.substring(startIndex, end);
             if(wordSet.contains(word)){
                 //append it into a sentence 
                 int currentLength = currentSentence.length();
                 currentSentence.append(word).append(" "); //DO  
                 //get the rest of the words
                 backtrack(s, wordSet, currentSentence, end); //end is the start index for rest of the string     
                 currentSentence.setLength(currentLength); //reset currentSentence to its original length;
             }
         }     
     }*/
    
    
    //Approach 2
    //DP - Memoization
    //List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        //result = new ArrayList<>();
        return backtrack(s, new HashSet<String>(wordDict), new HashMap<String,  List<String>>()); 
        //return result;
    }
    
    private List<String> backtrack(
        String remainingStr,
        Set<String> wordSet,
        Map<String, List<String>> map
    ){
        if(map.containsKey(remainingStr)){
            return map.get(remainingStr);
        }
        
        // Base case: when the string is empty, return a list containing an empty string
        if (remainingStr.isEmpty()) return Collections.singletonList("");
        
         List<String> result = new ArrayList<>();
        
        //check for every length of substring and if already substring of that length is processed then return the result there only
        for(int l = 1; l<=remainingStr.length(); l++){
            String word = remainingStr.substring(0,l);
            
            if(wordSet.contains(word)){
                String remainingWord = remainingStr.substring(l);
                
                //check for the nextword
                List<String> nextList = backtrack(remainingWord, wordSet, map);
                for(String next : nextList){
                    result.add(word + (next.isEmpty() ? "" : " ") + next);
                }
            }
        }
        
        map.put(remainingStr, result);
        return result;
    }
}