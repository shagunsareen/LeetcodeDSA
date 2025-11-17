class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        //approach 1 - tc : O(n2), sc : O(n2) 
        //store values of elements of each row and each col and each block in separate map 
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> cells = new HashMap<>();

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){

                if(board[row][col] == '.') continue;
                String squareKey = (row/3) + "," + (col/3);

                if(rows.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][col]) ||
                    cols.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col]) ||
                    cells.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[row][col]))
                {
                    return false;
                }

                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                cells.get(squareKey).add(board[row][col]);
            }
        }

        return true;

        */

        //Approach 2 - Bitmasking, we will check the ith bit in each array to see if the value at current row is set or not i.e. seen or not. 
        int N = 9;
        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){

                if(board[r][c] == '.') continue;

                int val = board[r][c] - '0';
                int pos = 1 << (val - 1); //if val was 5 we need to check 4th bit in arr whether its seen or not already
                
                if((rows[r] & pos) > 0){ //it will be 1 only if same bit is already 1 
                    return false;
                } 
                rows[r] = rows[r] | pos; //setting bit 

                if((cols[c] & pos) > 0){
                    return false;
                }

                cols[c] = cols[c] | pos;

                int boxIndex = (r / 3) * 3 + (c /3); //3 is multiplied to map each box as 0, 1 or 2 
                if((boxes[boxIndex] & pos) > 0){
                    return false;
                }

                boxes[boxIndex] = boxes[boxIndex] | pos;
            }
        }

        return true;
    }
}