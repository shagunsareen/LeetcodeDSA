class Solution {
    public String minRemoveToMakeValid(String s) { 
        
        StringBuilder sb = new StringBuilder();
        
        char[] ch = s.toCharArray();
        
        int count=0;
        
        //traverse string from left to right to get invalid closing parenthesis
        for(int i=0; i<ch.length; i++){
                if(ch[i] == '('){
                    count++;
                }else if(ch[i] == ')'){
                    if(count > 0){
                        count--;
                    }else{
                        //don't include this in the string
                        ch[i] = 0;
                    }
                }
        }
        
        //reset count value 
        count = 0;
        
        //traverse string from right to left to get invalid opening parenthesis
        for(int i=ch.length-1 ; i>=0; i--){
            if(ch[i] == '('){
                if(count > 0){
                    count--;
                }else{
                    ch[i] = 0;
                }
            }else if(ch[i] == ')'){
                count++;
            }
        }
        
        for(char c : ch){
            if(c != 0){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}