class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        
        int left=0;
        int right=people.length-1;
        
        //we should club the heaviest person with the lightest one , if still boat is heavy we should let heavy person go on that boat because every person has to go to the other end 
        while(left<=right){
            int weight = people[left] + people[right];
            if(weight <= limit){
                left++;
                right--;
            }else{
                right--; //means we are letting heavy person go on the boat 
            }
            boatCount++; //since we can send only 2 people on 1 boat hence we have to increment boat bcoz we are taking 2 people at a time
        }  
        return boatCount;
    }
}