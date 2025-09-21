class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        //first fill dp table with lcs logic because we will use it to print our ans as we will pick common ones jst once and rest of characters as is 
        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        //fill 0 length strings as 0 
        for(int row = 0; row <= n1; row++){
            dp[row][0] = 0;
        }
        for(int col = 0; col <= n2; col++){
            dp[0][col] = 0;
        }

        //fill other indexes 
        for(int row = 1; row <= n1; row++){
            for(int col = 1; col <= n2; col++){
                if(str1.charAt(row - 1) == str2.charAt(col -1)){
                    dp[row][col] = 1 + dp[row - 1][col -1];
                }else{
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        //now we have dp filled with longest common subsequence lengths at any possible index from both strings so we can use this to print our expected answer and then reverse this
        StringBuilder ans = new StringBuilder();
         //to iterate over both strings we need pointers for dp table rows and cols so that we can move them up and down
         int row = n1;
         int col = n2;

         while(row > 0 && col > 0){

           if(str1.charAt(row - 1) == str2.charAt(col - 1)){
                ans.append(str1.charAt(row - 1));
                row--;
                col--;
            }else if(dp[row - 1][col] > dp[row][col - 1]){ //if upper row col val is greater go there decrease row number
                ans.append(str1.charAt(row - 1)); //since we are moving up we include this char in ans
                row--;   
            }else{
                ans.append(str2.charAt(col - 1));
                col--;
            }
         }

         //whichever string is left take that 
         while(row > 0){
            ans.append(str1.charAt(row - 1));
            row--;
         }

         while(col > 0){
            ans.append(str2.charAt(col - 1));
            col--;
         }

         return ans.reverse().toString();
    }
}