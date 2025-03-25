class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> yEvents = new ArrayList<>();
        List<int[]> xEvents = new ArrayList<>();

        //distribute all rectangle points into different ranges
        for(int[] rectange : rectangles){
            yEvents.add(new int[]{rectange[1], 1}); //start y
            yEvents.add(new int[]{rectange[3], 0}); //end y
            xEvents.add(new int[]{rectange[0], 1}); //start x
            xEvents.add(new int[]{rectange[2], 0}); //end x
        }

        //sort as per the start time, if start time is same sort as per the end time 
        //yEvents.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        //xEvents.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        return countLineIntersections(yEvents) || countLineIntersections(xEvents);
    }

    private boolean countLineIntersections(List<int[]> events){
        events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int overlap = 0;
        int count = 0;

        for(int[] event : events){
            if(event[1] == 1){
                overlap++;
            }else{
                overlap--;
            }

            if(overlap == 0){
                count++;
            }
        }

        return count >= 3;
    }
}
