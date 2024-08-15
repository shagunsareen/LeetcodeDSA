class Solution {
   /* public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        
        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }*/
    
    /*public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        
        //since we need to check to not include the same letter, we take visited array where we mark an element as visited
        boolean visited[][] = new boolean[m][n];
        
        //check every cell to get the first element of the word. 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    //if we get the first char then we go and search other chars
                    result = backtrack(board, word, visited, i, j, 0);
                    if(result) return true;
                }
            }
        }
        return false;
    }
    
    //row and col indicates of the board , index indicates of the word char which we are finding 
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int row, int col, int index){
        //base condition
        if(index==word.length()){
            return true;
        }
        
        //check if the co-ordinates are correct
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        
        //if cell is already visited then we can't consider it
        if(visited[row][col]){
            return false;
        }
        
        //if char doesn't match what we are looking for   
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        
        visited[row][col] = true;
        
        //otherwise backtrack 
        if(backtrack(board, word, visited, row + 1, col, index + 1) ||
           backtrack(board, word, visited, row - 1, col, index + 1) ||
           backtrack(board, word, visited, row, col + 1, index + 1) ||
           backtrack(board, word, visited, row, col - 1, index + 1)){
            return true;
        }
        
        //if nowhere we got the answer then return false;
        //make the current element as not visited 
        visited[row][col] = false;
        return false;
    }*/
    
    
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {  
        char[] input = word.toCharArray();
        int size = input.length;
        int rows = board.length;
        int cols = board[0].length;
        int startRow = -1;
        int startCol = -1;
        visited = new boolean[rows][cols];
        
        //find the first element of the word in the board
        for(int row = 0; row<rows; row++){
            for(int col = 0; col<cols; col++){
                if(input[0] == board[row][col]){
                    startRow = row;
                    startCol = col;
                    if(backtrack(startRow, startCol, board, input, 0)){
                        return true;
                    } 
                }
            }
        }
        
        return false;
    }
    
    int[][] dirs = {{0,-1}, {0,1}, {1, 0}, {-1, 0}};
    
    private boolean backtrack(int row, int col, char[][] board, char[] input, int index){
        //base case 
        //check if we have found the entire word
        if(index == input.length){
            return true;
        }
        
        //check if the new points are valid or out of bound
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
 
        //check if this is not already visited then mark it as visited if word equals to the next word we are looking for
        if(!visited[row][col] && input[index] == board[row][col]){ 
            //System.out.println("ROW : "+row + " COL : "+col + " input word : "+ input[index] + " Board word : "+ board[row][col]);
            visited[row][col] = true;
        
            //we have start row so we can traverse in all 4 directions and check whether we get true or not
            for(int[] dir : dirs){

                int newRow = dir[0] + row;
                int newCol = dir[1] + col;
                
                //if points are valid then move forward to find other words
                if(backtrack(newRow, newCol, board, input, index+1)){
                    return true;
                }
            }
            
            visited[row][col] = false;
        }
        
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}