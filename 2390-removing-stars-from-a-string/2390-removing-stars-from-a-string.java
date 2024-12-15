class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){      
            if(ch != '*'){
                stack.push(ch);
            }else if(ch == '*' && !stack.isEmpty()){
                stack.pop(); //delete the left non-star character
            }
        }
        
        StringBuilder str = new StringBuilder();
        //iterate stack to return a string
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        
        return str.reverse().toString();
    }
}