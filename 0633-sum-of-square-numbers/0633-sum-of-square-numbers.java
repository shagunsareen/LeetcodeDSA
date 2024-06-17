class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;  //lower limit
        long b = (long) Math.sqrt(c);  //higher limit
        
        while(a <= b){
            long ans = a*a + b*b;
            if(ans > c){
                b--;
            }else if(ans < c){
                a++;
            }else{
                //if ans is equal to c then return true
                return true;
            }
        }   
    return false;
    }
}