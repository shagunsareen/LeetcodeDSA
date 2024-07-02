class Solution {
    int[][] dirs = {{0, 1}, {0,-1}, {1,0}, {-1, 0}, {1, -1}, {-1, 1}, {1,1}, {-1,-1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if((grid[0][0] == 1) || (grid[n-1][n-1] == 1))
            return -1;
        
        //we have to check the shortest path from 0,0 to n-1,n-1
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0}); 
        //mark this visited otherwise it will give TLE
        grid[0][0] = 2;
        
        int steps = 0;
        while(!queue.isEmpty()){
            
            int size = queue.size();

            for(int i=0; i<size; i++)
            { 
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
                
                if(currX == n-1 && currY == n-1)
                    return steps+1;
                
                for(int[] dir : dirs){
                    
                    int x1 = currX + dir[0];
                    int y1 = currY + dir[1];
                    
                    //check if the point is valid 
                    if(x1>=0 && x1<n && y1>=0 && y1<n && grid[x1][y1]==0){
                       queue.add(new int[]{x1, y1}); 
                       grid[x1][y1] = 2;
                    }
                }
            }
            steps++;
        }     
        return -1;
    }
}