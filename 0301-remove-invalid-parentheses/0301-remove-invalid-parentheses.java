class Solution {
    public List<String> removeInvalidParentheses(String s) {     
        //resultant set to store the valid parenthesis , since we dont want duplicate strings so we have taken set 
        Set<String> result = new HashSet<String>();
        int[] minRemovals = calculateMinRemovals(s);
        backtrack(result, s, new StringBuilder(), 0, 0, 0, minRemovals[0], minRemovals[1]);
        return new ArrayList<String>(result);
    }
    
    
    private void backtrack(Set<String> result, String s, StringBuilder current, int index, int openCount, int closedCount, int openRem, int closedRem){  
        //base case 
        if(index == s.length()){
            if(openCount == closedCount && openRem == 0 && closedRem == 0){
                result.add(current.toString());
            }
            return;
        }
          
        char c = s.charAt(index);

        //exclude current character if it is not an alphabet
        if(c == '(' && openRem > 0){
            backtrack(result, s, current, index+1, openCount, closedCount, openRem-1, closedRem);
        }
        if(c == ')' && closedRem > 0){
            backtrack(result, s, current, index+1, openCount, closedCount, openRem, closedRem-1);
        }
      
        //include current character
        current.append(c);
        if(c == '('){ 
            backtrack(result, s, current, index+1, openCount+1, closedCount, openRem, closedRem);
        }else if(c == ')'){
            if(closedCount < openCount){
                backtrack(result, s, current, index+1, openCount, closedCount+1, openRem, closedRem);   
            }      
        }else{
            //if its alphabet
            backtrack(result, s, current, index+1, openCount, closedCount, openRem, closedRem);
        }
        current.deleteCharAt(current.length()-1);
    }
    
    private int[] calculateMinRemovals(String s) {
        int openRem = 0, closeRem = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openRem++;
            } else if (c == ')') {
                if (openRem > 0) { //valid pair
                    openRem--;
                } else {
                    closeRem++;
                }
            }
        }
        return new int[]{openRem, closeRem};
    }
}