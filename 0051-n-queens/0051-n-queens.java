class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    
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
    }
    
    
    
    /*//hashset for column
    HashSet<Integer> col = new HashSet<Integer>();
    // hashset for right diagonal
    HashSet<Integer> rd = new HashSet<Integer>();
    //hashset for left diagonal 
    HashSet<Integer> ld = new HashSet<Integer>();

    List<List<String>> res = new ArrayList<List<String>>();

    int N;
    int mat[][];

    // update every col with . in the matrix
	public List<List<String>> solveNQueens(int A) {
        N = A; // no. of rows and columns
        mat =  new int[N][N];

        for(int[] row : mat){
            Arrays.fill(row, 0);
        }
        printNQueens(0);
        return res;
	}

    private void printNQueens(int row){

        //Base condition
        if(row == N){ //if we have reached row as out of bound then print 
            res.add(getStringRepresentation(mat));
            return;
        }

        //Choices to place Queen is every col in each row
        for(int c=0; c<N; c++){ // check for every col if we can place queen there or not
            //Check if we already have queen at col or in right diagonal or in left diagonal
            if(!col.contains(c) && !rd.contains(row+c) && !ld.contains(row-c)){
                //DO : placed queen
                mat[row][c] = 1; 
                col.add(c);
                rd.add(row+c);
                ld.add(row-c);

                // go and place the next queen
                printNQueens(row+1);

                //UNDO : unplace queen 
                mat[row][c] = 0;
                col.remove(c);
                rd.remove(row+c);
                ld.remove(row-c);
            }
        }  
    }

    ArrayList<String> getStringRepresentation(int[][] mat){
        ArrayList<String> list = new ArrayList<>();

        for(int row=0; row<mat.length; row++){
            StringBuilder str = new StringBuilder(mat[0].length);
            for(int col=0; col<mat[0].length; col++){
                if(mat[row][col] == 0){
                    str.append('.');
                }else{
                    str.append('Q');
                }
            }
            list.add(str.toString());
        }
        return list;
    }*/
}