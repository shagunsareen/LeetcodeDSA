class Solution {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        
        //1. collect all possible adjacent positions where the 0 can go if it is at that particular index
        int[][] directions = new int[][]{
            {1,3}, 
            {0,2,4}, 
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
        };
        
        
        StringBuilder startState = new StringBuilder();  
        //we have to understand this problem as moving from start point to the end point. Start state will keep on changing till we reach the end point and if we don't reach end point we return -1
        
        //convert 2D array to string rep
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                startState.append(board[i][j]);
            }
        }
        
        //put this startState to the queue and mark it as visited 
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(startState.toString());
        queue.add(startState.toString());
        
        int moves=0;
        
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- != 0){
                
                String currState = queue.poll();
                
                //check if this is same as target 
                if(currState.equals(target)){
                    return moves;
                }
                
                //if it is not then go and check adjacent positions to swap 0 
                int zeroPos = currState.indexOf('0');
                
                //get adjacent elements of zeroPos
                for(int newPos : directions[zeroPos]){
                    
                    //swap 
                    String nextState = swap(currState, zeroPos, newPos);
                    
                    //push to queue if not visited
                    if(visited.contains(nextState)) continue;
                    
                    ///else mark it visited and push to queue
                    visited.add(nextState);
                    queue.add(nextState);
                    
                }
            }
            moves++;
        }     
       return -1;
    }
    
    //swap chars at both indices 
    private String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}