class Solution {
    //https://leetcode.com/problems/find-all-groups-of-farmland/discuss/1444086/C%2B%2B-Straight-forward-approach-no-super-mind-(Commented)
    /*public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(land[i][j] == 1) {
                    extendReach(i, j, land, list);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    
    private void extendReach(int x, int y, int[][] land, List<int[]> list) {
        int endX = x;
        int endY = y;
        //Find ending y co-ordinate for the Farmland
        while(endY+1 < land[0].length && land[x][endY+1] == 1) {
            land[x][endY+1] = 0;
            endY++;
        }
        
        //Find ending x co-ordinate for the Farmland
        while(endX+1<land.length && land[endX+1][y] == 1) {
            land[endX+1][y] = 0;
            endX++;
        }
        
        //Fill the rectangular Farmland with zeroes
        //To avoid revisitng/recounting
        for(int i=x; i<=endX; i++) {
            for(int j=y; j<=endY; j++) {
                land[i][j] = 0;
            }
        }
        
        list.add(new int[]{x, y, endX, endY});
    }*/
    
    List<int[]> list = new ArrayList<>();
    private int bottom = 0;
    private int right = 0;
    
    public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(land[i][j] == 1){
                    
                    //storing initial co-ordinates 
                    int[] coordinates = new int[4];
                    
                    coordinates[0] = i; //top left indexes 
                    coordinates[1] = j;
                    bottom = i; //default bottom right indexes if there is only 1 element in the island
                    right = j;
                    
                    dfs(land, i, j);
                    
                    coordinates[2] = bottom;
                    coordinates[3] = right;
                    list.add(coordinates);
                }
            }
        }
        return list.toArray(new int[list.size()][]); 
    }
    
    private void dfs(int[][] land, int row, int col){
        int rows = land.length;
        int cols = land[0].length;
        
        //where to stop or in which case it is of no use
        if( row >= rows || row<0 || col<0 || col>=cols || land[row][col] == 0){
            return;
        }
        
        //mark the current cell as visited 
        land[row][col] = 0;
        
        //check whether this is the max index or not
        bottom = Math.max(bottom, row);
        right = Math.max(right, col);
        
        //then find if we can get max bottom right point
        dfs(land, row+1, col); //Bottom 
        dfs(land, row, col+1); //Right
        dfs(land, row-1, col); //Up
        dfs(land, row, col-1); //Left
    }
    
}