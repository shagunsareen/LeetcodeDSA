class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // we can make a list of how many employees a manager can inform to
        //we need to make an adjacency list for all the nodes
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjacencyList.add(new ArrayList<>());
        }
        
        //add the child employees
        for(int i=0; i<n; i++){
            //<manager, list<employees>>
            if(manager[i] != -1){
                adjacencyList.get(manager[i]).add(i);
            }   
        }
        
        //start the dfs from head of the organisation
        return dfs(headID, informTime, adjacencyList);
    }
    
    
    private int dfs(int node, int[] informTime, List<List<Integer>> adjacencyList){
        int ans = 0;
        
        //get the time required to inform all employees by doing dfs for all child employees who are reporting to the input node
        for(int v : adjacencyList.get(node)){
            ans = Math.max(ans, dfs(v, informTime, adjacencyList));
        }
        
        return ans + informTime[node];
    }
}