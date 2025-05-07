class Solution {
    int[][] directions = new int[][]{{0,1}, {0,-1}, {-1, 0}, {1,0}};

    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        for(boolean[] arr : visited){
            Arrays.fill(arr, false);
        }

        //iterate over grid and find cell with 1 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                   bfs(i, j, visited, grid);
                   count++;
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, boolean[][] visited, char[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }

        if(visited[row][col] || grid[row][col] == '0'){
            return;
        }

        //mark it visited 
        visited[row][col] = true;

        //go to all neighbours
        for(int[] dir : directions){
            int x1 = row + dir[0];
            int y1 = col + dir[1];

            bfs(x1, y1, visited, grid);
        }
    }

}