class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        //insert elements to the stack 
        
        for(int num : asteroids){       
            //push if the element is positive
            if(num > 0){
                stack.push(num);
            }else{ //num < 0 
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(num)){
                   stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() > 0 && stack.peek() == Math.abs(num)){ //this will eventually move to the next element as this is not in while loop
                    stack.pop();
                }   
                else if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(num);
                }
            }
        }
        
        //iterate over stack to create result 
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}