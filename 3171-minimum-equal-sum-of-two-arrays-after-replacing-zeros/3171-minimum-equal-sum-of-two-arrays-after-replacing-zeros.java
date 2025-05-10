class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0; 
        long sum2 = 0;
        long zero1 = 0;
        long zero2 = 0;

        for(int i : nums1){
            sum1 += i;
            if(i == 0){
                sum1++; //adding 1 to the sum
                zero1++;
            }
        }

        for(int i : nums2){
            sum2 += i;
            if(i == 0){
                sum2++; //adding 1 to the sum
                zero2++;
            }
        }

        if((zero1 == 0 && sum1 < sum2) || (zero2 == 0 && sum1 > sum2)){
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}