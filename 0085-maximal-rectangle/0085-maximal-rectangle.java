class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int m = matrix[0].length; //columns
        int n = matrix.length; //rows
            
            
        //construct column prefix sum 
        for(int j=0; j<m; j++){
            for(int i=1; i<n; i++){
                
                //check if the current element is 0 or 1 
                if(matrix[i][j] == '1'){
                    matrix[i][j] += matrix[i-1][j] - '0';
                }else{
                    matrix[i][j] = '0';
                }
            }
        }
        int ans = 0;
        int res = 0;
        
        //now calculate area for each histogram
        for(int i=0; i<n; i++){
            
            // Convert char[] to int[]
            int[] heights = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                heights[j] = matrix[i][j] - '0'; // Convert char to int
            }
            
           // int[] convertedArr = convertToIntArr(matrix[i]);
            ans = largestRectangleArea(heights);  //sending row wise 
            res = Math.max(ans, res);
        }
        
        return res;
    }
    
    /*private int[] convertToIntArr(char[] row){
        int[] heights = Arrays.stream(row)
                              .mapToInt(c -> c - '0') // Convert char to int
                              .toArray();
        
        return heights;
    }*/
    
    private int largestRectangleArea(int[] heights) {
        
        //since every height can be in the ans let's take every height as ans height and calculate area
        //To get area we need prevSmallerIndex and nextSmallerIndex
        int[] leftSmallerIndexArr = prevSmallerIndex(heights);
        int[] rightSmallerIndexArr = nextSmallerIndex(heights);
        int maxArea = 0;
        
        //now calculate the area
        for(int i=0; i<heights.length; i++){
             int leftIndex = leftSmallerIndexArr[i];
             int rightIndex = rightSmallerIndexArr[i];
             int height = heights[i];
            
             int width = rightIndex - leftIndex - 1;
             maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }
    
    
    private int[] prevSmallerIndex(int[] heights){
        //we use stack since we need previous elements 
        Stack<Integer> stack = new Stack<>();
        int[] leftSmallerIndexArr = new int[heights.length];
        Arrays.fill(leftSmallerIndexArr, -1);
        
        for(int i=0; i<heights.length; i++){
            
            //if greater ele is in stack remove it 
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                //remove greater element on the left
                stack.pop();
            }
            
            //if we get smaller element in stack than curr height then mark stack ele as smallerLeftIndex
            if(!stack.isEmpty() && heights[stack.peek()] < heights[i]){
                leftSmallerIndexArr[i] = stack.peek();
            }
            
            //insert every element since it can be an answer for future elements
            stack.push(i);
        }
        
        return leftSmallerIndexArr;
    }
    
    
    private int[] nextSmallerIndex(int[] heights){
        //we use stack since we need previous elements from the right
        Stack<Integer> stack = new Stack<>();
        int[] rightSmallerIndexArr = new int[heights.length];
        Arrays.fill(rightSmallerIndexArr, heights.length);
        
        for(int i=heights.length-1; i>=0; i--){
            
            //if greater ele is in stack remove it 
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                //remove greater element on the left
                stack.pop();
            }
            
            //if we get smaller element in stack than curr height then mark stack ele as smallerLeftIndex
            if(!stack.isEmpty() && heights[stack.peek()] < heights[i]){
                rightSmallerIndexArr[i] = stack.peek();
            }
            
            //insert every element since it can be an answer for future elements
            stack.push(i);
        }
        
        return rightSmallerIndexArr;
    }
}