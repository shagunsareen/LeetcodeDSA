class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //sort as per pairs fraction in ascending order
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1]));
        
        int n = arr.length;
        
        //insert all pairs into pq
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                 minHeap.add(new int[]{arr[i], arr[j]});
            }     
        }
        
        int[] result = null;
        //pick kth element from pair
        for(int i=0; i<k; ++i){
            result = minHeap.poll();
        }
        
        return result;
    }
}