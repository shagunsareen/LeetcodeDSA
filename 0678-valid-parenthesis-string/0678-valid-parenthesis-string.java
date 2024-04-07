class Solution {
    public boolean checkValidString(String s) {
        int openPCount = 0;
        int closedPCount = 0;
        int n = s.length() - 1;
        
        //Traverse open parenthesis from left to right
        for(int i=0; i<=n; i++){
            //count open parenthesis or asterisks
            if(s.charAt(i) == '(' || s.charAt(i) == '*') {
                openPCount++;
            }else{
                openPCount--; //if we encounter closed paranthesis then it means we have a pair
            }
            
            
            //count closed parenthesis or asterisks
            if(s.charAt(n - i) == ')' || s.charAt(n - i) == '*'){
                closedPCount++;
            }else{
                closedPCount--; //if we encounter open parenthesis then decrement the count since we got a pair
            }
            
            //check if we have any negative count that means we have unbalanced parenthesis then it's a valid string
            if(openPCount < 0 || closedPCount < 0){
                return false;
            }
        }
        
        /*for(char c : ch){
            if(c == '(') openPCount++;
            else if(c == ')') closedPCount++;
            else starCount++;
        }
        
        System.out.println(" openPCount : "+ openPCount + ", closedPCount : "+closedPCount + ", starCount : "+starCount);
        
        if((openPCount == closedPCount) || 
           ((openPCount + starCount) == closedPCount) ||
            ((closedPCount + starCount) == openPCount)){
            return true;
        }*/
        
        return true;
    }
}