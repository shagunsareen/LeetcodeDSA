class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        //since we have to find shortest path steps we should go with BFS because in DFS we will get the longest path since we move till the end of the path
        int row = maze.length;
        int col = maze[0].length;
        
        //we have to start from entrance so we put the first node in the queue
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        //mark this as visited so that others should not visit this
        maze[entrance[0]][entrance[1]] = '+';
        
        //to go in all 4 directions we should have directions array 
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        int steps = 0;
        
        while(!queue.isEmpty()){    
            
            int[] current = queue.poll(); 
            
            //go in all 4 directions from here 
            for(int k=0; k<4; k++){
                int x1 = current[0] + dx[k];
                int y1 = current[1] + dy[k];
                
                //check if this point is not out of bounds
                if(x1 < 0 || y1 < 0 || x1 >= row || y1 >= col){
                    continue;
                }
                
                //check if this is already visited
                if(maze[x1][y1] == '+') continue;
                
               //check if this has reached the wall
                if(x1==0 || y1==0 || x1==row-1 || y1==col-1){
                    return current[2] + 1;
                }
                
                //else mark it as visited and put it in the queue
                maze[x1][y1] = '+';
                
                queue.offer(new int[]{x1, y1, current[2] + 1});
            }
        }     
        return -1;
    }
}