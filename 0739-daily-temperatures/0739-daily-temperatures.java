class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //next greatest element 
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
    
        for(int i=n-1; i>=0; i--){   
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp >= temperatures[stack.peek()]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;  
            stack.push(i);
        }
        return result;
    }
}