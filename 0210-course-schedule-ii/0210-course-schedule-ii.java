class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        
        //we should pick course with no dependency i.e. 0 indegree
        
        //Step1 : adjacencyList 
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        int[] indegree = new int[n];
        
        for(int i=0; i<n; i++){
            adjacencyList.add(new ArrayList<>());
        }
        
        //add neighbouring nodes
        for(int[] edge : prerequisites){
            adjacencyList.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        //get the nodes with 0 indegree
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        
        int[] res = new int[n];
        int index = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res[index] = curr;
            index++;
            
            for(int neighbour : adjacencyList.get(curr)){
                indegree[neighbour]--;
                
                if(indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }
        
        System.out.println(res.length);
        
        return index == n ? res : new int[]{};
    }
}