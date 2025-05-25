class Solution {

    //bfs since we need to traverse each row and then move further deep 
    public int orangesRotting(int[][] grid){

        //Step 1 : Find rotten oranges and put in queue to process them 
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;

        Queue<int[]> queue = new LinkedList<>();
        int minutesElapsed = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j}); //add row and col to the queue of the rotten orange 
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0){
            return 0;
        }

        int[][] dirs = {
            {0, -1},
            {0, 1}, 
            {-1, 0},
            {1, 0}
        };
        
        while(!queue.isEmpty()){       
            int size = queue.size();
            boolean rotten = false;

            //traverse each level in the tree
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for(int[] dir : dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX < 0 || newY < 0 || newX >= n || newY >= m){
                        continue;
                    }

                    if(grid[newX][newY] == 1){
                        grid[newX][newY] = 2;

                        queue.add(new int[]{newX, newY});
                        freshOranges--;
                        rotten = true;
                    }
                }
            }

            if(rotten){
                minutesElapsed++;
            }
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}