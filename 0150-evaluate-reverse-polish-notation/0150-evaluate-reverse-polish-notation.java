class Solution {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

    static{
        OPERATIONS.put("+", (a,b) -> a + b);
        OPERATIONS.put("-", (a,b) -> a - b);
        OPERATIONS.put("*", (a,b) -> a * b);
        OPERATIONS.put("/", (a,b) -> a / b);
    }
    
    public int evalRPN(String[] tokens) {  
    /*   Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if("+*-/".contains(token)){        
                int num2 = stack.pop();
                int num1 = stack.pop();

                int result = 0;

                switch(token){
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                
                stack.push(result);
            }else{
                stack.push(Integer.valueOf(token));
            }

        }
        return stack.pop(); 
    */

        //Lambda solution
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(OPERATIONS.containsKey(token)){        
                int num2 = stack.pop();
                int num1 = stack.pop();
                
                BiFunction<Integer, Integer, Integer> operation;
                operation = OPERATIONS.get(token);
                int result = operation.apply(num1, num2);
                stack.push(result);
            }else{
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}