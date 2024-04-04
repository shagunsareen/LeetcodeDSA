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
    
    public boolean exist(char[][] board, String word) {
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
    }
    
}