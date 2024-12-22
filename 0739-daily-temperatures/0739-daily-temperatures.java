class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //this question is similar to next greater element to the right 
        //we will store greater elements in the stack and will remove the smaller elements from the stack if greater element appears 
        
        //traverse from right to left 
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        res[n-1] = 0;
        stack.push(n-1);
        
        for(int i=n-2; i>=0; i--){           
            while(!stack.isEmpty() && temperatures[stack.peek()]  <= temperatures[i]){
                stack.pop(); 
            }            
            if(stack.isEmpty()){
                res[i] = 0;
            }else{
                 res[i] = stack.peek() - i;
            }           
            stack.push(i);
        }
        
        return res;
    }
}