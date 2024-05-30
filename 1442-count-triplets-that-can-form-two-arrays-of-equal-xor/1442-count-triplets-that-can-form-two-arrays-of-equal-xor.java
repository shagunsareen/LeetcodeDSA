class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        
        //Approach 1 - brute force
        int count = 0;
        
        // Iterate over each possible starting index i
        for(int i=0; i<n-1; i++)
        {
            int xorA = 0;
            
            //Iterate over each possible middle index j
            for(int j=i+1; j<n; j++)
            {
                xorA ^= arr[j-1];
                int xorB = 0;

                for(int k=j; k<n; k++){
                    xorB ^= arr[k];
                     
                    if(xorA == xorB){
                        count++;
                    }
                }   
            }
        }
        return count;
    }
}