class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //since it needs shortest distance so we will apply BFS
        //we will traverse from all 0s and update the distance only if it is shorter than the previous one 
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        //put all 0s to the queue
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){ //processing cells level by level and updating distance accordingly   
                int[] curr = queue.poll();
                
                for(int[] dir : dirs){ //go in all 4 directions
                    int x1 = curr[0] + dir[0];
                    int y1 = curr[1] + dir[1];
                    
                    //check if this is already visited and check the distance 
                    if(x1 >=0 && x1<n && y1>=0 && y1<m && mat[x1][y1] > mat[curr[0]][curr[1]] + 1){
                        mat[x1][y1] = mat[curr[0]][curr[1]] + 1;
                        queue.add(new int[]{x1, y1});
                    }
                }
            }
        }
        return mat;
    }
}