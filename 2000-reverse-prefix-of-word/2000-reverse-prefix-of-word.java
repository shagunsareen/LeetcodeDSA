class Solution {
    public String reversePrefix(String word, char ch) {
        //find the index of the ch in the word and then reverse string from 0 to that index
        int chIndex = word.indexOf(ch);
        if(chIndex == -1){
            return word; 
        }
        
        StringBuilder str = new StringBuilder();
        
        for(int i=0; i<word.length(); i++){
            if(i<=chIndex){
                str.append(word.charAt(chIndex - i));  //add the ch to string in reverse order
            }else{
                str.append(word.charAt(i)); //append as it is 
            }   
        }
        return str.toString();
    }
}