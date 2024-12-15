class Solution {
    public String decodeString(String s) {
        
        Stack<Object> stack = new Stack<Object>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + ch - '0';
            }else if(ch == '['){
                stack.push(currentString.toString()); //push string so far
                stack.push(k); //push the multiplier
                //reset the string
                k = 0;
                currentString = new StringBuilder(); 
            }else if(ch == ']'){
                //form the string using prev string and multiply the k 
                int count = (int)stack.pop();
                StringBuilder temp = new StringBuilder((String)stack.pop()); //prevString
                
                for(int i=0; i<count; i++){
                      temp.append(currentString);
                }
                currentString = temp; //update currentString with new result 
            }else{
                currentString.append(ch); //here we are creating string
            }
        }
        
        return currentString.toString();
    }
}