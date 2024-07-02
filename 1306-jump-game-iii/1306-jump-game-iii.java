class Solution {
    public boolean canReach(int[] arr, int start) {
        
        //base case - check out of bound and visited elements
        if(start < 0 || start >= arr.length || arr[start] < 0 ){
            return false;
        }
        
        //positive scenario
        if(arr[start] == 0)
            return true;
        
        
        //mark as visited
        //arr[start] = -arr[start];
        
        // return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        
        // Mark as visited by negating the value
        arr[start] = -arr[start];

        // Recursive calls to check both possible jumps
        boolean canReachLeft = canReach(arr, start + arr[start]);
        boolean canReachRight = canReach(arr, start - arr[start]);

        // Restore the original value if you need to reuse the array
        arr[start] = -arr[start];

        // Return if any path is successful
        return canReachLeft || canReachRight;
    }
}