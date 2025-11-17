class Solution {
    public boolean isValidSudoku(char[][] board) {
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
    }
}