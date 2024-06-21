class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int unsatisfied = 0;
        
        //calculate unsatisfied customers in the first window
        for(int i=0; i<minutes; i++){
            unsatisfied += customers[i]*grumpy[i]; //since if grumpy is 0 then those customers won't be added 
        }
        
        int maxUnsatisfiedCustomers = unsatisfied;
        //now we need to increase incoming unsatisfied customers and remove left from window unsatisfied customers
        for(int i=minutes; i<customers.length; i++){
            unsatisfied += customers[i]*grumpy[i];  //add if grumpy
            unsatisfied -= customers[i-minutes]*grumpy[i-minutes]; //remove previous 
            
            maxUnsatisfiedCustomers = Math.max(maxUnsatisfiedCustomers, unsatisfied);
        }
        
        //now we know where can we get the maximum unsatisfied customers so we will count them in satisfied
        //and we will add rest of the actual satisfied customers in the totalCount
        int totalCustomers = maxUnsatisfiedCustomers;
        for(int i=0; i<customers.length; i++){
            totalCustomers += customers[i]*(1-grumpy[i]); //since we have to add 1's customers     
        }
        
        return totalCustomers;
    }
}