class Solution {
    public int countDays(int days, int[][] meetings) {     
        //Merge intervals approach 
       /*Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
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
        }
        count = days - daysWorked;
        return count; */

        //Approach 2 : Line sweep algo   
        //split every interval to +1 when it starts and -1 when it ends so that if prefix sum is taken it gives correct count of meeting during that interval 
        List<int[]> time = new ArrayList<>();
        for(int[] meeting : meetings){
            time.add(new int[]{meeting[0], 1}); //entering bus example
            time.add(new int[]{meeting[1] + 1, 0}); //leaving room example
        }
        
        //Sort it as per start time
        time.sort((a,b) -> Integer.compare(a[0], b[0]));
        
        //Apply Line-sweep 1D
        int overlap = 0;
        int count = time.get(0)[0] - 1; //count free time before start

        for(int i=0; i<time.size()-1; i++){ //we will check till second last interval since we will handle last interval separately
            if(time.get(i)[1] == 0) overlap--;
            else overlap++;

            if(overlap == 0){
                //means there are no overlap meetings 
                count += time.get(i+1)[0] - time.get(i)[0];
            }
        }
        count += days - time.get(time.size() - 1)[0] + 1;
        return count;
    }
}