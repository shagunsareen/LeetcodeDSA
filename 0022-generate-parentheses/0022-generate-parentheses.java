class Solution {
    List<String> result;
    int openCount = 0;
    int closedCount = 0;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder str = new StringBuilder(); 
        backtrack(str, openCount, closedCount, n); //max parenthesis count is 2n
        return result;
    }
    
    private void backtrack(StringBuilder str, int openCount, int closedCount, int max){
        
        //base case 
        // check if count has reached max limit
        if(str.length() == 2*max){
            result.add(str.toString());
            return;
        }
        
        //check if openCount is less than max
        if(openCount < max){
            //append ( parenthesis
            str.append('(');
            backtrack(str, openCount + 1, closedCount, max);
            str.deleteCharAt(str.length()-1);
        }
        
        
        //check if closedCount is less than openCount then we can append closed parenthesis
        if(closedCount < openCount){
            //append ) parenthesis
            str.append(')');
            backtrack(str, openCount, closedCount + 1, max);
            str.deleteCharAt(str.length()-1);
        }
    }
}