/*class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int rows = box.length;
        int cols = box[0].length;
        
        //System.out.println(rows + " - "+ cols);
        
        char[][] res = new char[cols][rows];
        
        for(int row = rows-1; row>=0; row--){
            for(int col = cols-1; col>=0; col--){        
                char curr = box[row][col];
                if(col != cols-1){
                    char prev = res[col+1][rows-1-row];
                    if(curr == '#' && prev == '.'){
                        curr = '.';
                        prev = '#';
                        res[col+1][rows-1-row] = prev;
                    }
                } 
                //first find at what index will the new value be stored 
                res[col][rows-1-row] = curr;
            }
        }
        return res;
    }
}*/
    
class Solution {

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
}