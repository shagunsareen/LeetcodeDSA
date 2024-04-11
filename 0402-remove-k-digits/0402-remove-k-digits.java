class Solution {
    public String removeKdigits(String num, int k) {
        
        //edge case 
        if(num.length() == k){
            return "0";
        }
        
        //insert the smaller characters of the string to a stack to maintain a monotonic increasing stack i.e. we remove any digits greater than incoming digits since we want smallest number so we want it on the left most position 
        
        Stack<Character> stack = new Stack<>();
        
        //Traverse over the digits one by one and remove larger digits 
        for(int i=0; i<num.length(); i++){
            char curr = num.charAt(i);
            
            while(!stack.isEmpty() && k>0 && curr < stack.peek()){
                stack.pop(); //remove the top element of the stack and let smaller element get into the stack
                k--;
            }
            
            stack.push(curr);   
        }
        
        //For corner case where we didn't find any smaller element after greater element is inserted then we are inserted    elements and not removing  eg : 112 , k=1
        while(k>0){
            stack.pop();
            k--;
        }
        
        //construct string from stack
        StringBuilder strB = new StringBuilder();
        while(!stack.isEmpty()){
            strB.append(stack.pop());
        }
        
        strB.reverse();
        
        //remove the trailing zeros from the string 
        while(strB.length() > 1 && strB.charAt(0) == '0'){
            strB.deleteCharAt(0);
        }
        
        return strB.toString();
    }
}