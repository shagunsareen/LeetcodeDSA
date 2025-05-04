class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        Map<String, Integer> map = new HashMap<>();
        int pairsCount = 0;

        for(int[] dominoe : dominoes){

            int a = Math.min(dominoe[0], dominoe[1]);
            int b = Math.max(dominoe[0], dominoe[1]);

            String key = a + "," + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        //all pairs freq is inserted into map hence count pairs formed from freq
        for(int val : map.values()){
            pairsCount += val * (val-1) / 2;
        }

        return pairsCount;
    }
}