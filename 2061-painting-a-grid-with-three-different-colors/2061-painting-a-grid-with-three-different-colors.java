class Solution {
   
    private static final int MOD = 1000000007;
    private int[][] dp = new int[1002][1024]; //dp array stores at which column how many states are possible to color, possible states range from 0 to 1024 since in each column we will have max 5 rows so 5 colors we can keep and if each color corresponds to 2 bits then its 10 bits with which we can make 1024 combinations

    public int colorTheGrid(int m, int n) {
        
        //fill dp array with -1
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        //return no. of ways in which we can color valid combinations
        return countWays(m, n, 0, 0, 0, 0);
    }

    private int countWays(int m, int n, int r, int c, int curr_state, int prev_state){
        //return 1 if we have reached last column as we are filling values col wise 
        if(c == n) return 1;

        if(r == m) return countWays(m, n, 0, c+1, 0, curr_state);

        if(r == 0 && dp[c][prev_state] != -1) return dp[c][prev_state]; 

        int up_color = 0;
        if(r > 0) up_color = curr_state & 3;  //& 3 is like bitmasking last 2 digits i.e. it returns last 2 bits of a  number 

        int left_color = (prev_state >> ((m-r-1) * 2)) & 3; 

        int ways_to_color = 0;
        for(int color = 1; color<=3; color++){
            if(color != up_color && color != left_color){
                ways_to_color = (ways_to_color + countWays(m, n, r+1, c, (curr_state << 2) | color, prev_state)) % MOD;
            }
        }

        if(r == 0){
            dp[c][prev_state] = ways_to_color;
        }

        return ways_to_color;
    }
}