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
    List<String> result;
    
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
     }
}