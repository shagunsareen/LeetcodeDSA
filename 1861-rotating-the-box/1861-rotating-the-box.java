class Solution {
    public char[][] rotateTheBox(char[][] box) {      
        int rows = box.length;
        int cols = box[0].length;
        
        char[][] res = new char[cols][rows];
        
        for(int row = 0; row<rows; row++){
            
            int empty = cols-1;
            
            for(int col = cols-1; col>=0; col--){
                
                char curr = box[row][col];
                
                //System.out.println("Row : "+ row + " Col : "+col + " Curr : "+curr);
                
                if(curr == '#'){
                   res[empty][rows-1-row] = '#';
                    if(empty!=col){
                         res[col][rows-1-row] = '.';
                    } 
                   empty--;
                }else if(curr == '*'){
                    res[col][rows-1-row] = '*';
                    empty = col-1;
                }else{
                    res[col][rows-1-row] = '.';
                }
            } 
            
        }
        return res;
    }
}
    
/*class Solution {

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        // Initialize the result grid with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = '.';
            }
        }

        // Apply gravity to let stones fall to the lowest possible empty cell in each column
        for (int i = 0; i < m; i++) {
            int lowestRowWithEmptyCell = n - 1;
            // Process each cell in row `i` in reversed order
            for (int j = n - 1; j >= 0; j--) {
                // Found a stone - let it fall to the lowest empty cell
                if (box[i][j] == '#') {
                    // Place it in the correct position in the rotated grid
                    result[lowestRowWithEmptyCell][m - i - 1] = '#';
                    lowestRowWithEmptyCell--;
                }
                // Found an obstacle - reset `lowestRowWithEmptyCell` to the row directly above it
                if (box[i][j] == '*') {
                    // Place the obstacle in the correct position in the rotated grid
                    result[j][m - i - 1] = '*';
                    lowestRowWithEmptyCell = j - 1;
                }
            }
        }
        return result;
    }
}*/