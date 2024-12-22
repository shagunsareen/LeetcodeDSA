class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        
        int[] result = new int[q];
        Arrays.fill(result, -1);
        
        //query buckets store list for each element where it will be max index of the query pair. int[] : height required , index of the query where this index is max
        //for every index it will store list of queries where it is max index
        List<List<int[]>> queryBuckets = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            queryBuckets.add(new ArrayList<>());
        }
        
        for(int i=0; i<q; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            
            //we have to ensure that a<b
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            
            //if a < b then check height 
            if(heights[b] > heights[a] || a == b){
                result[i] = b; // a can move to b building since all constraits match
            }else{
                //if height of a is greater than b then we need to find next greater building where both can meet 
                queryBuckets.get(b).add(new int[]{ heights[a], i}); 
            }
        }
        
        //This int[] stores building heights and index of each building in the decreasing order of height
        List<int[]> monoStack = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            //resolve queries for the current building
            for(int[] query : queryBuckets.get(i)){
                int height = query[0];
                int queryIndex = query[1];
                
                int position = findGreaterBuildingIndex(monoStack, height); //this will find building index which has height greater than what we want
                if(position != -1){
                    result[queryIndex] = monoStack.get(position)[1];
                }
            }
            
            //maintain monotonic decreasing stack
            while(!monoStack.isEmpty() &&  monoStack.get(monoStack.size() - 1)[0] <= heights[i]){
               monoStack.remove(monoStack.size() - 1);
            }
            
            monoStack.add(new int[] { heights[i], i });
            
        }
        
        return result;
    }
    
    
    private int findGreaterBuildingIndex(List<int[]> stack, int height) {
        List<int[]> stackList = new ArrayList<>(stack);
        int left = 0, right = stackList.size() - 1, ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (stackList.get(mid)[0] > height) {
                ans = mid; // Save the last valid position
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
    
}