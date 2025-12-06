class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = heights.length;
        int maxArea = 0;

        for(int i=0; i<n; i++){    
            //pop greater elements as we want to keep smaller prev elements in stack 
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]){ //rectangle cant be formed with curr smaller height so take stack top as end of rectangle 
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1; // rightBoundary : curr index , leftBoundary : stack top index after popping
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i); 
        }

        //if stack has values then calculate area while popping elements
        while(stack.peek() != -1){
            int currHeight = heights[stack.pop()];
            int currWidth = n - stack.peek() - 1; //rightBoundary here is n as we have reached end of array 
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }

        return maxArea;
    }
}