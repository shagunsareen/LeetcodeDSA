class Solution {
    public int[][] merge(int[][] intervals) {
        //this will sort the array on the basis of start points of the arrays
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        
        for(int[] interval : intervals){
            
            //check for overlap 
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);   
            }else{
                newInterval = interval;
                result.add(newInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}