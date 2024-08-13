class Solution {
    /*List<List<String>> res = new ArrayList<List<String>>();
    
    HashSet<Integer> col = new HashSet<Integer>();
    HashSet<Integer> leftDiagonal = new HashSet<Integer>();
    HashSet<Integer> rightDiagonal = new HashSet<Integer>(); 
    int N = 0;
    int[][] board;
    
    public List<List<String>> solveNQueens(int n) {
        //setting size value 
        N = n;
        //create a board of nxn first
        board = new int[n][n];
        
        for(int[] row : board){
            Arrays.fill(row,0);
        }
        
        printNQueens(0);
        
        return res;
    }  
    
    private void printNQueens(int row){
        
        //base condition
        if(row == N){
            System.out.println(printResult(board));
            res.add(printResult(board));
            return;
        }
        
        //in a row go to every column, check if it is valid to put queen in this column 
        for(int c = 0; c < N; c++){
            
            //Check if we already have a queen at that col or in right diagonal or in left diagonal
            if(!col.contains(c) && !rightDiagonal.contains(row+c) && !leftDiagonal.contains(row-c)){
                //DO : place queen
                board[row][c] = 1;
                col.add(c);
                rightDiagonal.add(row+c);
                leftDiagonal.add(row-c);
                
                //go and place the next queen in next row
                printNQueens(row+1);
                
                //UNDO : unplace the queen
                board[row][c] = 0;
                col.remove(c);
                rightDiagonal.remove(row+c);
                leftDiagonal.remove(row-c);
            }
        }
    }
    
    
    private ArrayList<String> printResult(int[][] board){
        ArrayList<String> list = new ArrayList<>();
        
        for(int row=0; row<board.length; row++){
            StringBuilder str = new StringBuilder(board[0].length);
            for(int col=0; col<board[0].length; col++){
                if(board[row][col] == 0){
                    str.append('.');
                }else{
                    str.append('Q');
                }
            }
            list.add(str.toString());
        }    
        return list;
    }*/
    
    List<List<String>> result;
    int[][] board; 
    int size = 0;
    HashSet<Integer> colSet = new HashSet<Integer>();
    HashSet<Integer> leftDiagonalSet = new HashSet<Integer>();
    HashSet<Integer> rightDiagonalSet = new HashSet<Integer>(); 
    public List<List<String>> solveNQueens(int n) {
        size = n;
        result = new ArrayList<>();
        //create a board 
        board = new int[n][n];
        //iterate over all rows and try to put queen on all columns and see if its valid or not
        getQueensPlacement(0);
        return result;
    }
    
    
    private void getQueensPlacement(int row){
        //base case 
        if(row == size){
            result.add(printResult(board));
            return;
        }
        
        //check for every row col pair
        for(int col=0; col<size; col++){
            //check if already queen is in this row or col or diagonal
            if(!colSet.contains(col) && !leftDiagonalSet.contains(row-col) && !rightDiagonalSet.contains(row+col)){
                board[row][col] = 1;
                colSet.add(col);
                leftDiagonalSet.add(row-col);
                rightDiagonalSet.add(row+col);
                
                getQueensPlacement(row+1);
                
                board[row][col] = 0;
                colSet.remove(col);
                leftDiagonalSet.remove(row-col);
                rightDiagonalSet.remove(row+col);
            }
        }   
    }
    
    
    private ArrayList<String> printResult(int[][] board){  
        ArrayList<String> result = new ArrayList<>();
        for(int row = 0; row<board.length; row++){
            StringBuilder str = new StringBuilder();
            for(int col = 0; col<board.length; col++){
                if(board[row][col]==0){
                    str.append('.');
                }else{
                    str.append('Q');
                }
            }
             result.add(str.toString());
        }
       return result;
    }    
}