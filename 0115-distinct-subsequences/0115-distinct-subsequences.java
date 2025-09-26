class Solution {

    //Memoization
    /*int[][] dp;
    int prime = (int) (Math.pow(10, 9) + 7);
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n][m];

        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }

        return checkMemoizaiton(dp, n-1, m-1, s, t);
    }

    private int checkMemoizaiton(int[][] dp, int index1, int index2, String s, String t){
        if(index2 < 0){//we found all chars of t in s 
            return 1;
        }

        if(index1 < 0){ //we couldnt find all. chars of t in s 
            return 0;
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }

        if(s.charAt(index1) == t.charAt(index2)){
            int leave = checkMemoizaiton(dp, index1-1, index2-1, s, t) ;
            int stay = checkMemoizaiton(dp, index1-1, index2, s, t);
            dp[index1][index2] = ( leave + stay ); //it might happen that char in t can match with other characters in s to give us more subsequences 
        }else{
            dp[index1][index2] =  checkMemoizaiton(dp, index1-1, index2, s, t); //we need each character of t to find match in s so 
        }

        return dp[index1][index2];
    }*/

    //Tabulation
    /*public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1]; 

        //base cases - when j = 0 means string 2 is empty that is we have nothing to compare 
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 1;
        }

        //for i == 0 it means we have nothing to compare so no subsequence can be formed
        for(int j=1; j < m+1; j++){ //this j starts from 1 because j = 0 & i = 0 will give empty subsequence so it should be 1
            dp[0][j] = 0;
        }

        for(int row = 1; row < n+1; row++){
            for(int col = 1; col < m+1 ; col++){

                if(s.charAt(row-1) == t.charAt(col-1)){
                    int leave = dp[row-1][col-1];
                    int stay = dp[row-1][col];
                    dp[row][col] = ( leave + stay ); //it might happen that char in t can match with other characters in s to give us more subsequences 
                }else{
                    dp[row][col] =  dp[row-1][col]; //we need each character of t to find match in s so 
                }
            }
        }
        return dp[n][m];
    }*/

    //Space optimisation
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] prev = new int[m+1]; 
        prev[0] = 1;
        
        for(int row = 1; row < n+1; row++){
            for(int col = m; col >= 1 ; col--){ //since we need prev row same col and prev row prec col we can store curr val in prev row same col this cant be done if we move col index from 0 to m as for computing we would override values which will be used in future computation
                if(s.charAt(row-1) == t.charAt(col-1)){
                    int leave = prev[col-1];
                    int stay = prev[col];
                    prev[col] = ( leave + stay ); //it might happen that char in t can match with other characters in s to give us more subsequences 
                }else{
                    prev[col] =  prev[col]; //we need each character of t to find match in s so 
                }
            }
        }
        return prev[m];
    }
}