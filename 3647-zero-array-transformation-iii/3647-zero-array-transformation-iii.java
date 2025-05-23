class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int queryPos = 0;
        int appliedCount = 0;

        int n = nums.length;
        PriorityQueue<Integer> usedQuery = new PriorityQueue<>(); //min heap - sort it by end points 
        PriorityQueue<Integer> availableQuery = new PriorityQueue<>(Collections.reverseOrder()); //max heap - to pick query with highest endpoint

        //sort queries to pick lowest index starting query first 
        Arrays.sort(queries, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i=0; i<n; i++){
            //we need to process each element index wise so we check which queries are available for this index
            //get all these queries and push it into queue to get query with longest end point
            while (queryPos < queries.length && queries[queryPos][0] == i) {
                 availableQuery.offer(queries[queryPos][1]); 
                 queryPos++;
            }

            //check in used query if there is any query that already can cover this index...in usedQuery wee will only store indexes which should cover current index
            nums[i] -= usedQuery.size(); 

            //now apply more queries from available queries if still more operations can be done 
            while(nums[i] > 0 && !availableQuery.isEmpty() && availableQuery.peek() >= i){
                int end = availableQuery.poll();
                usedQuery.offer(end);
                nums[i]--;
                appliedCount++;
            }

            //if nums[i] couldn't be reduced to zero
            if(nums[i] > 0){
                return -1;
            }

            //remove queries that end at 'i' from usedQuery
            while(!usedQuery.isEmpty() && usedQuery.peek() == i){
                usedQuery.poll();
            }
        }
        return queries.length - appliedCount; 
    }
}