class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        //sandwich
        Stack<Integer> stack = new Stack<>();
        
        //students
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        //populate stack and queue
        for(int i=0; i<students.length; i++){
            queue.offer(students[i]);
            stack.push(sandwiches[sandwiches.length - 1 - i]);
        }
        
        //processing all students
        while(!queue.isEmpty()){
             //now compare top of stack and queue
            if(stack.peek() == queue.peek()){
                stack.pop();
                queue.poll();
                count = 0;
            }else{
                int moveStudent = queue.poll();
                queue.offer(moveStudent);
                count++;
            }
            
            if(queue.size() == count){
                break;
            }
        }
        return queue.size();
    }
}