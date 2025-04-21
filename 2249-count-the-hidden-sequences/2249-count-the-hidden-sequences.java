class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        //start + diff[0] = second ele
        //start + diff[0] + diff[1] = third ele
        //start + diff[0] + diff[1] + diff[2] = fourth ele
        //so start + min sum >= lower
        //and start + max sum <= upper
        //else return 0
        int x=0; 
        int y=0;
        int curr=0; //running prefix sum
        for(int d : differences){
            curr += d; //prefix sum
            x = Math.min(curr, x);
            y = Math.max(curr, y);

            if( (y-x) > (upper - lower)){
                return 0;
            }
        }
        return (upper - lower) - (y - x) + 1; //ele in range [a,b] is b-a+1
    }
}