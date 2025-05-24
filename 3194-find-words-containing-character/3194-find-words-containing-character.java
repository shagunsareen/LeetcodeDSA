class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        int n = words.length;

        for(int i = 0; i < n; i++){
            String currWord = words[i];
            for(int ch = 0; ch < currWord.length(); ch++){
                char curr = currWord.charAt(ch);
                if(curr == x){
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}