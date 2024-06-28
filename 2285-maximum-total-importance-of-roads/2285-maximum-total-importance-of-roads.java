class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        
        //create the degree array of each node
        for(int[] edge : roads){
            degree[edge[0]]++; //incrementing degree of 0th index element of array in the list 
            degree[edge[1]]++; //incrementing degree of 1st index element of array in the list
        }
        
        Arrays.sort(degree);
        
        //now as per the degree we will assign the values to the nodes
        long value = 1;
        long totalImportance = 0;
        
        for(long d : degree){
            totalImportance += (value*d);        
            value++;
        }
        
        return totalImportance;
    }
}