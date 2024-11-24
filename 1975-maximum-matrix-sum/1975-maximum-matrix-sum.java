class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negValCount = 0;
        int minAbsVal = Integer.MAX_VALUE;
        
        for(int[] row : matrix)
        {       
            for(int val : row)
            {
               totalSum += Math.abs(val);           
                if(val < 0)  
                {
                    negValCount++; //maintain the count of negative elements so that we should know whether entiresum can be considered or not
                }
                
                minAbsVal = Math.min(minAbsVal, Math.abs(val));
             }
         } 
        
        //check if count is odd or even
        if(negValCount % 2 != 0){
            totalSum -= 2*minAbsVal;
        }
        
        return totalSum;
    }
}