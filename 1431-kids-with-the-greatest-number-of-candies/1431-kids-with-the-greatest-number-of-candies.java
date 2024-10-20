class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        
        //find max candies kid has 
        for(int i : candies){
            max = Math.max(i, max);
        }
        
        for(int kidCandyCount : candies){
            if((kidCandyCount + extraCandies) >= max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }    
}