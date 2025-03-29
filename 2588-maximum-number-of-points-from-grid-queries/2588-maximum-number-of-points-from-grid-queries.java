import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int qsize = queries.length;
        int[] result = new int[qsize];

        //we need sorted queries since we will use points calculated for lower value integers for higher valued integers but we need to return answer in input order so we store queries with index in an array
        
        int[][] sortedQueries = new int[qsize][2];
        for(int i=0; i<qsize; i++){
            sortedQueries[i][0] = queries[i]; //element
            sortedQueries[i][1] = i; //storing original index of queries
        }

        Arrays.sort(sortedQueries, (a,b) -> a[0] - b[0]);

        //min heap will process cells in increasing order of value
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]); //this is needed to keep track of cells that can be visited next to consider points

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        //insert the top left cell as its given in question that we need to start from top left cell
        // curr val, curr row, curr col
        minHeap.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;

        //process for all queries 
        for(int[] query : sortedQueries){
            int queryValue = query[0];
            int queryIndex = query[1];

            while(!minHeap.isEmpty()){
                int[] curr = minHeap.poll();
                int cellValue = curr[0];
                int cellRow = curr[1];
                int cellCol = curr[2];

                if(cellValue >= queryValue){
                    minHeap.add(curr); //since this doesn't meet queryval condition it might meet other queryval condition
                    break; 
                }

                //else count this cell as valid
                count++;

                //check all neighbours 
                for(int[] direction : dir){
                    int newRow = cellRow + direction[0];
                    int newCol = cellCol + direction[1];

                    //check if it is valid and not visited, then push the neighbour to minheap
                    if(isValid(newRow, newCol, rows, cols) && !visited[newRow][newCol]){
                        //value , row, col
                        minHeap.add(new int[]{grid[newRow][newCol], newRow, newCol});
                        //mark them visited
                        visited[newRow][newCol] = true; 
                    }
                }  
            }

            //store result for this query
            result[queryIndex] = count;
        }

        return result;
    }

    private boolean isValid(int newRow, int newCol, int rows, int cols){
        return newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols;
    }

}