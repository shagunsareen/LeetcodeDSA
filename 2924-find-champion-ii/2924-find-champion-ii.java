class Solution {
    public int findChampion(int n, int[][] edges) {
        
        //take an array to store in degree count for every team 
        //since n is small we can store indegree count in array itself by tracking index 
        int[] indegreeArr = new int[n];
        
        //traverse all the edges and increament the count of incoming edge team
        for(int[] edge : edges){
            indegreeArr[edge[1]]++;
        }
        
        int potentialCount = 0;
        int potentialAns = -1;
        
        //now check how many integers have indegree count as 0 
        for(int i=0; i<n; i++){
            if(indegreeArr[i]==0){
                potentialCount++;
                potentialAns = i; 
            }      
        }
        
        if(potentialCount==1){
            return potentialAns;
        }else{
            return -1;
        }
    }
}