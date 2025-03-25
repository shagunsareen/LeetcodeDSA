class Solution {
    public int countDays(int days, int[][] meetings) {
        /*int freeDays = 0, latestEnd = 0;

        // Sort meetings based on starting times
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Add current range of days without a meeting
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }

            // Update latest meeting end
            latestEnd = Math.max(latestEnd, end);
        }

        // Add all days after the last day of meetings
        freeDays += days - latestEnd;

        return freeDays;*/

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int daysWorked = 0;
        int n = meetings.length;

        for(int i=0; i<n; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];

            while(i+1 < n && end >= meetings[i+1][0]){ //meaning we have overlapping intervals
                end = Math.max(end, meetings[i+1][1]);    
                i++;
            }

            daysWorked += end - start + 1;
            System.out.println(daysWorked);
        }

        count = days - daysWorked;
        return count;
    }
}