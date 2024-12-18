class Solution {
    public int[] finalPrices(int[] prices) {
        
        //Approach 1 : Brute force since constraints are less
        int n = prices.length;
        
        for(int i=0; i<n; i++){//to go to each element
            
            for(int j=i+1; j<n; j++){
                
                if(prices[j] <= prices[i]){
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        
        return prices;
    }
}