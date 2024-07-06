class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length==0)
            return 1;
        
        int[] count = new int[n+1]; //since we have to check nth nodes frequency as well
        
        //calculate indegree and outdegree, the element whose at the end degree will be n-1 is the winner
        for(int[] edge : trust){
            count[edge[0]]--;
            count[edge[1]]++;
        }
        
        //check element whose degree is n-1
        for(int i=0; i<=n; i++){
            if(count[i] == n-1)
                return i;
        }
        
        return -1;
    }
}