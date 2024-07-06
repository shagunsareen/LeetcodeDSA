class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        //we have to check which nodes have no incoming edges since the ones which have no incoming edges will be reachable only by themselves
        int[] indegree = new int[n]; 
        
        for(int i=0; i<edges.size(); i++){
            List<Integer> edge = edges.get(i); 
            
            //store the indegree , edge goes from 0th index to 1st index element , we store the opposite since we want to store indegree count 
            indegree[edge.get(1)]++;
        }
        
        //now we have indegress now check which all nodes have 0 and put it in result
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0)
                result.add(i);
        }
        
        return result;
    }
}