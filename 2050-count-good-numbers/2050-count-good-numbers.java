class Solution {
    long mod = 1000000007;

    //even numbers btw 0 to 9 are 0, 2, 4, 6, 8 i.e. 5
    //odd prime numbers btw 0 to 9 are 1,3,5,7 i.e. 4 
    //Take any number of length n it will have odd numbers always as n/2 since for odd length numbers one extra digit would always be of even index so even numbers would be n-n/2
    //for even numbers we have 5 choices for each element, for odd number we have 4 choices for each element so we calculate combinations with odd and even numbers
    
    public int countGoodNumbers(long n) {
        return (int)((binaryExponential(4, n/2) * binaryExponential(5, n-n/2))%mod);
    }

    private long binaryExponential(long base, long power){ //half the power, square the base, multiple res by base each time 
        long res = 1;

        while(power > 0){

            if(power % 2 != 0){
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            power /= 2;
        }

        return res;
    }
}