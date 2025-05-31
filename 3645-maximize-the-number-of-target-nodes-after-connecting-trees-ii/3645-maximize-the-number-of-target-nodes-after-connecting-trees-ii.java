class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        List<List<Integer>> neigh1 = build(edges1, n1);
        List<List<Integer>> neigh2 = build(edges2, n2);

        int[] count2 = bfs(0, neigh2, null);
        int evenCount2 = count2[0];
        int oddCount2 = count2[1];
        int best2 = Math.max(evenCount2, oddCount2);
       
        boolean[] isEvenLevel = new boolean[n1];
        int[] count1 = bfs(0, neigh1, isEvenLevel);
        int evenCount1 = count1[0];
        int oddCount1 = count1[1];
        
        int[] res = new int[n1];

        for(int i=0; i<n1; i++){
            if(isEvenLevel[i]){
                res[i] = evenCount1 + best2;   
            }else{
                res[i] = oddCount1 + best2;
            }
        }

        return res;
    }

    private List<List<Integer>> build(int[][] edges, int n){

        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }

    //return even nodes from starting node 
    private int[] bfs(int startNode, List<List<Integer>> neighbours, boolean[] isEvenLevel){
        int n = neighbours.size(); //node count int tree

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(startNode);
        visited[startNode] = true;

        int level = 0;
        int even = 0;
        int odd = 0;
    
        while(!queue.isEmpty()){ 
            int size = queue.size();

            for(int i=0; i<size; i++){
                int curr = queue.poll();

                if(level % 2 == 0){
                    even++;
                    if(isEvenLevel != null){
                        isEvenLevel[curr] = true;
                    }    
                }else{
                    odd++;
                }

                for(int neigh : neighbours.get(curr)){
                    if(!visited[neigh]){
                        visited[neigh] = true;
                        queue.offer(neigh);
                    }
                }
            }

            level++;
        }
        return new int[]{even, odd};
    }
}