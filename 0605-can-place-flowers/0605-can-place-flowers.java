class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowersPlaced = 0;
        int m = flowerbed.length;
        
        for(int i=0; i<m; i++){
            if(flowerbed[i] == 0)
            {
                boolean emptyLeftPlot = (i==0) || (flowerbed[i-1] == 0);
                boolean emptyRightPlot = (i==m-1) || (flowerbed[i+1] == 0);
         
                if(emptyLeftPlot && emptyRightPlot){
                     flowerbed[i] = 1;
                    flowersPlaced++;
                }
            }
        }        
        return flowersPlaced >= n;
    }
}