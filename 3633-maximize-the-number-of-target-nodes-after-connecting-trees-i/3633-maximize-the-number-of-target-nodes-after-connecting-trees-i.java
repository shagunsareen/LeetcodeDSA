class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        //find count of reachable nodes in k-1 hops for tree 2 from every node of tree 2
        //get max of that count so we get max count of nodes from tree2
        //do bfs from each node of tree1 to get count of nodes it can cover in k hops and add tree1 count to that 
        int n1 = edges1.length + 1; //Vertices = Edges + 1
        int n2 = edges2.length + 1;

        int maxCountTree2 = 0;
        for(int i=0; i<n2; i++){
            int countTree2 = bfs(i, edges2, k-1);
             maxCountTree2 = Math.max(maxCountTree2, countTree2);
        }
        
        int[] res = new int[n1];
        for(int j=0; j<n1; j++){
            int countTree1 = bfs(j, edges1, k);
            res[j] = countTree1 + maxCountTree2;  //updating count of k distant nodes in tree1 nodes 
        }

        return res;
    }

    private List<List<Integer>> build(int[][] edges){
        int n = edges.length + 1;
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>()); //list for each node
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }

    private int bfs(int startNode, int[][] edges, int k){
        List<List<Integer>> neighbours = build(edges); //it will have adj list for each node so its size gives number of nodes in our tree
        boolean[] visited = new boolean[neighbours.size()];

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(startNode);
        visited[startNode] = true;
        int level = 0;
        int count = 0;

        while(!queue.isEmpty() && level <= k){
            int size = queue.size(); 
            count += size; //count all nodes at this level 

            for(int i=0; i<size; i++){
                int curr = queue.poll();

                for(int neighbour : neighbours.get(curr)){ //add all nodes at one level 
                    if(!visited[neighbour]){
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }

            level++;
        }
        return count;
    }
}