class Solution {
    public void setZeroes(int[][] matrix) {
        
        //iterate over entire array to mark row and col as negative wherever 0 is encountered
        int n = matrix.length;
        int m = matrix[0].length;
        
        /* FAILED - This could have worked if negative values were not allowed in matrix , since neg are allowed we dont have unique marker value that we can use 

        int marker = Integer.MIN_VALUE + 1; 

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){

                    //mark row as non negative 
                    for(int col=0; col < m; col++){
                        if(matrix[i][col] != 0 && matrix[i][col] != marker){
                            matrix[i][col] = marker;
                        }      
                    }

                    //mark in col as well
                    for(int row=0; row<n; row++){
                        if(matrix[row][j] != 0 && matrix[row][j] != marker){
                             matrix[row][j] = marker;
                        }    
                    }
                }
            }
        }

        //for all marker values update them back to 0
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == marker){
                    matrix[i][j] = 0;
                }
            }
        }
        */


        //Approach 2 - without marker 
        boolean zeroRow = false;
        boolean zeroCol = false;
        
        //first row
        for(int col=0; col<m; col++){
            if(matrix[0][col] == 0){
                zeroRow = true;
            }
        }

        //first col
        for(int row=0; row<n; row++){
            if(matrix[row][0] == 0){
                zeroCol = true;
            }
        }

        //mark rows and cols using first row and first col 
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] == 0){
                    //mark row and col as 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //zero out marked rows 
        for(int i=1; i<n; i++){
            if(matrix[i][0] == 0){
                for(int j=1; j<m; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        //zero out marked cols
        for(int j=1; j<m; j++){
            if(matrix[0][j] == 0){
                //fill the entire col with 0
                for(int i=1; i<n; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        //check if zeroth row had 0 or not 
        if(zeroRow){
            for(int col = 0; col<m; col++){
                matrix[0][col] = 0;
            }
        }

        //mark zeroth col zeros if it had 0 
        if(zeroCol){
            for(int row = 0; row < n;  row++){
                matrix[row][0] = 0;
            }
        }

    }
}