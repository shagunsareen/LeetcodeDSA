class Solution {
    public String reverseWords(String s) {
        char[] ch = s.trim().toCharArray();
        int n = ch.length;
        
        //reverse the entire string
        reverse(ch, 0, n-1);
        
        //reverse each word in the string
        int start = 0;
        int end = 0;
        
        while(end < n){   
            while(end < n && ch[end] != ' '){
                end++;
            }

            //when we get the first space we got the current end index hence swap this word
            reverse(ch, start, end-1);

            end++;
            start = end;
        } 
    
        return cleanUpSpaces(ch, n);
    }
    
    private String cleanUpSpaces(char[] ch, int n){
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<ch.length; i++){ //iterate over entire array to create reversed sentence
            if(ch[i] != ' '){
                //now append the space before start of the word but before the first word
                if(result.length() > 0){
                    result.append(' ');
                }
                
                while(i<n && ch[i]!=' '){
                    result.append(ch[i]);
                    i++;
                }
                
            }
        }
       return result.toString(); 
    }
    
    private void reverse(char[] ch, int start, int end){
        while(start<end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

}