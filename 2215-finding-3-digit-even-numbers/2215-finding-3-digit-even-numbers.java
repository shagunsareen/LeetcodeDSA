class Solution {
    public int[] findEvenNumbers(int[] digits) {
        //freq of each digit in array since range is small
        int[] freq = new int[10];
        for(int num : digits){
            freq[num]++;
        }

        List<Integer> result = new ArrayList<>();
        for(int num = 100; num <= 998; num += 2){
            int a = num/100;
            int b = ( num/10 ) % 10;
            int c = num % 10;

            int[] temp = freq.clone();
            if(temp[a]-- > 0 && temp[b]-- > 0 && temp[c]-- > 0){
                result.add(num);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}