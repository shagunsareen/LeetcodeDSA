class Solution {
    public int countSymmetricIntegers(int low, int high) {
        //if the number has even no. of digits then we can check whether it is symmetric or not 
        //if its even then divide number by into 2 halves and check sum of each half 
        int res = 0;

        for(int num = low; num <= high; num++){
            if(num < 100 && num % 11 == 0){
                res++;
            }else if(1000 <= num && num < 10000){
                int left = (num/1000) + (num / 100)%10;
                int right = (num % 10) + (num % 100)/10;
                if(left == right){
                    res++;
                }
            }
        }
        return res;
    }
}