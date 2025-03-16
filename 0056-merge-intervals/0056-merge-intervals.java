class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the intervals to. know which can overlap 
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        //we dont know how many elements would be there after merging hence int[][] can't be declared since size is not known, hence take list which stores merged intervals
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){

            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){ //non overlapping 
                merged.add(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}