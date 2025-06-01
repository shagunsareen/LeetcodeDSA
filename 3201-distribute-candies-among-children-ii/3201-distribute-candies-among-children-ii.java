class Solution {
    public long distributeCandies(int n, int limit) {
        return (
            cal(n+2) - //Total number of non-negative integer solutions
            3 * cal(n - limit + 1) + //Subtract cases where one child exceeds the limit
            3 * cal(n - (limit + 1) * 2 + 2) - //Add back solutions where at least two children exceed limit (because these were subtracted twice).
            cal(n - 3 * (limit + 1) + 2) //Subtract solutions where all three children exceed limit (because these were added back one time too many).
        );
    }

    private long cal(int x){
        if(x < 0){
          return 0;
        }

        return ((long) x * (x - 1)) / 2;
    } 
}