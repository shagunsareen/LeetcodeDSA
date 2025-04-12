class Solution {
    private long[] fact = new long[11]; //if n = 10 then fact size has to be n+1 
    Set<Long> set = new HashSet<>();
    private long kPalindromes = 0;

    public long countGoodIntegers(int n, int k) {
        precomputeFactorial(n);
        StringBuilder number = new StringBuilder();
        for(int i=0; i<n; i++){
            number.append(' ');
        }
        generatePalindromes(0, n, number, k);
        return kPalindromes;
    }

    private boolean isKPalindrome(String number, int n , int k){
        return Long.parseLong(number) % k == 0; // as per question since we have already set numbers as palindrome so we odnt have to check whether its palindrome or not
    }

    private long countAllPermutations(int[] freq, int n){
        long count = fact[n];
        for(int i=0; i<=9; i++){
            count /= fact[freq[i]];
        }
        return count;
    }

    private long getPermutations(String number, int n){
        char[] numArray = number.toCharArray();
        Arrays.sort(numArray);
        String sortedNumber = new String(numArray);
        long num = Long.parseLong(sortedNumber);
        if(set.contains(num)){
            return 0;
        }

        //else add it to set
        set.add(num);

        //create frequency array to check duplicates and 0s count
        int[] freq = new int[10];
        for(char c : sortedNumber.toCharArray())
        {
            freq[c - '0']++;
        }

        long totalPermutations = countAllPermutations(freq, n);
        long invalidPermutations = 0;

        if(freq[0] > 0){ // permutations starting from 0 are not allowed and are invalid 
            freq[0]--;
            invalidPermutations = countAllPermutations(freq, n-1);
        }
        return totalPermutations - invalidPermutations;
    }

    private void generatePalindromes(int pos, int n, StringBuilder number, int k){
        //base case where generatePalindromes recursion should stop
        if(pos >= (n+1)/2){
            String numStr = number.toString();
            if(isKPalindrome(numStr, n, k)){
                kPalindromes += getPermutations(numStr, n);
            }
            return;
        }

        char start = (pos == 0) ? '1' : '0';

        while(start <= '9'){
            number.setCharAt(pos, start);
            number.setCharAt(n-pos-1, start); //copying same number at start index and end index
            generatePalindromes(pos + 1, n, number, k); //dfs
            start++;
        }

        number.setCharAt(pos, ' '); //UNDO STEP
    }

    private void precomputeFactorial(int n){
        fact[0] = 1;
        fact[1] = 1;
        for(int i=2; i<=n; i++){
            fact[i] = i * fact[i-1];        
        }
    }
}