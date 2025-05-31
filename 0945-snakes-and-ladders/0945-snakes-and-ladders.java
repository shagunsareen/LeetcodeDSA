class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int dest = n*n;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); //starting cell is 1 and it goes till n*n till 36 so visited node index has to be till 37

        boolean[] visited = new boolean[dest + 1];
        visited[1] = true;

        int level = 0;
        while(!queue.isEmpty()){
            int size  = queue.size(); //process nodes at each level and then increment level so that we can get result count that in how many hops we reached destination
                        
            for(int i=0; i<size; i++){
                int curr = queue.poll();

                if(curr == dest)
                    return level;

                
                //else go to each cell where you can go from curr cell 
                for(int next = curr + 1; next <= Math.min(curr + 6, dest); next++){
                    int destination = next;

                    //now you have to mark this cell as visited in 1D array so that next time you csan decide whether you can go to this cell or not
                    //but to mark it we need row and col number 

                    int row = (next - 1)/n;
                    int col = (next - 1)%n; 

                    //zig zag row 
                    if(row % 2 == 1){
                        col = n - 1 - col; //since its odd row numbers would be reverse
                    }

                    row = n - 1 - row; //since we start from bottom to top 

                    if(board[row][col] != -1){
                        //either ladder or snake 
                        destination = board[row][col];
                    }

                    if(!visited[destination]){
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            level++;
        }
        return -1;
    }  
}