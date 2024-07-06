class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return result;
        }
        
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        //we will travserse left side cells and right side cells and mark visited nodes in pacific and atlantic ocean
        for(int i=0; i<n; i++){
            dfs(i, 0, heights, pacific, Integer.MIN_VALUE); //left row
            dfs(i, m-1, heights, atlantic, Integer.MIN_VALUE); //right row
        }
        
        //we will traverse top and bottom side cells and mark visited nodes in pacific and atlantic ocean
        for(int i=0; i<m; i++){
            dfs(0, i, heights, pacific, Integer.MIN_VALUE); //top row
            dfs(n-1, i, heights, atlantic, Integer.MIN_VALUE); //bottom row
        }
        
        //check cells that will flow the water to both the oceans & return the result
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int i, int j, int[][] heights, boolean[][] visitedOcean, int prevHeight){
        
        //check the cell is valid 
        if( i<0 || j<0 || i>=heights.length || j>=heights[0].length || visitedOcean[i][j] || prevHeight > heights[i][j]){
            return;
        }
        
        //mark the cell as visited 
        visitedOcean[i][j] = true;
        
        //check the adjacent cells height , if it is less water will flow inside
        int[][] dirs = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        
        for(int[] dir : dirs){
            int x1 = i + dir[0];
            int y1 = j + dir[1];
            
            dfs(x1, y1, heights, visitedOcean, heights[i][j]);
        }
    }
}








