class Solution {
    private static final int mod = 1000000007;
    public int maximumScore(List<Integer> nums, int k) {
        //Step 1 : GET PRIMES & PRIME SCORE
        //get prime factors using seive method. To apply seive we need to know the max element till which we want to know prime numbers
        int maxEle = Collections.max(nums);

        //apply seive 
        List<Integer> primes = getPrimeNumbers(maxEle);
        int n = nums.size();
        int[] primeScores = new int[n];

        //calculate prime score for all numbers
        for(int i=0; i<n; i++){
            int currNum = nums.get(i);

            //check from primes list how many are currNums factors
            for(int prime : primes){
                if(prime * prime > currNum) break;
                if(currNum % prime != 0) continue; //skip as this prime num is not currNum's factor
                primeScores[i]++; 
                while(currNum % prime == 0) {
                    currNum = currNum / prime ; //since we dont want to count this prime multiple times remove duplicates 
                }
            }

            //if number is still greater than 1 its itself prime
            if(currNum > 1) primeScores[i]++;
        }

        //STEP2 : get previous greater element index and next greater element index so that we have indexes to calculate contribution count of curr element in subarrays
        int[] ngi = new int[n];
        int[] pgi = new int[n];
        Arrays.fill(ngi, n);
        Arrays.fill(pgi, -1); 
        
        //stack to store decreasing prime score since we need elements with more prime score
        Stack<Integer> decreasingPrimeScoreStack = new Stack<>();
        for(int index=0; index<n; index++){

            while(!decreasingPrimeScoreStack.isEmpty() && 
                   primeScores[decreasingPrimeScoreStack.peek()] < primeScores[index]){ //remove all smaller ones from stack 
                int peekEleIndex = decreasingPrimeScoreStack.pop(); //for the peekele index curr ele is the next greater so we are updating next greater ele here only for peek ele             
                ngi[peekEleIndex] = index;
            }

            if(!decreasingPrimeScoreStack.isEmpty()){
                pgi[index] = decreasingPrimeScoreStack.peek();
            }
            decreasingPrimeScoreStack.push(index); //since this is greater ele till now
        }

        //STEP3 : Calculate subarray count in which ele is dominant
        long[] subarrayCount = new long[n];
        for(int index = 0; index < n; index++){
            subarrayCount[index] = (long)(ngi[index] - index)*(index - pgi[index]);
        }

        //STEP4 : sort elements in decreasing order since we pick greater element first
        List<int[]> sortedElements = new ArrayList<>();
        for(int index=0; index < n; index++){
            sortedElements.add(new int[]{nums.get(index), index});
        }

        sortedElements.sort((a,b) -> Integer.compare(b[0], a[0])); 

        long score = 1;
        int currIndex = 0;
        
        //process k times
        while(k > 0){
            int[] element = sortedElements.get(currIndex++);
            int num = element[0];
            int index = element[1];

            //operations on curr element
            long operations = Math.min(k, subarrayCount[index]);

            //update score
            score = (score * power(num, operations)) % mod;
            k -= operations;
        }

        return (int) score;
    }

    private List<Integer> getPrimeNumbers(int limit){
        boolean[] isPrime = new boolean[limit+1];  //since we need to store whether limit is also prime or not we keep size as limit + 1
        Arrays.fill(isPrime, true);
        List<Integer> result = new ArrayList<>();

        for(int num=2; num<=limit; num++){
            //check if its already computed
            if(!isPrime[num]) continue;

            result.add(num); //mark it as prime

            //mark all its factors as non prime 
            for(long multiple = num*num; multiple <= limit && multiple >= 0; multiple+=num){
                if (multiple > limit) break;  // Prevent out-of-bounds access
                isPrime[(int)multiple] = false;
            }
        }

        return result;
    }

    private long power(long base, long exponent){
        long res = 1;

        while(exponent > 0){
            if(exponent % 2 == 1){
                res = ( res * base ) % mod; // 2 power 3 then multiply extra base to result
            }
            base = (base * base) % mod; // half the exponent and multiple base to base 
            exponent /= 2; 
        }
        return res;
    }
}