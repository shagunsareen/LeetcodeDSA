class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    /*here if we apply topological sort i.e. we will find the node with indegree as 0 because it will not have any dependency or pre-requisite to complete any course, decrease the degree of others once current node is served i.e once current course is  omplete as one dependency is reduced for other courses, and if any course dependency becomes 0 then process that course and complete it*/
        
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        //here adjacencyList means key will be the course that on completion will reduce degree of which nodes 
        for(int i=0; i<numCourses; i++){
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int[] edge : prerequisites){
            adjacencyList.get(edge[1]).add(edge[0]); 
            indegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        //check which node has 0 indegree and put those to queue
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        int count = 0;
        
        //process 0 indegree queues
        while(!queue.isEmpty()){
            int curr  = queue.poll();
            count++;
            
            //decrease indegree of its adjacent nodes
            for(int neighbourNodes : adjacencyList.get(curr)){
                indegree[neighbourNodes]--;
                
                if(indegree[neighbourNodes] == 0)
                    queue.add(neighbourNodes);
            }
        }
        
        return count == numCourses;
    }
}