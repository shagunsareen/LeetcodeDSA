class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        //binary search on answer
        //min time that can be taken is 1 min by 1 rank person
        //max time can be taken if minRank person is doing all the cars 
        long low = 1;
        long high = Arrays.stream(ranks).min().getAsInt()*(long)cars*cars;
        long ans = 0;

        while(low <= high){
            long mid = (low + high)/2;

            if(canRepairCarsInTime(ranks, cars, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canRepairCarsInTime(int[] ranks, int carsToRepair, long timeToRepair){
        long repairedCars = 0;

        //check how many cars it can repair 
        for(int rank : ranks){
            repairedCars += Math.sqrt(timeToRepair/rank); //since time taken to repair = rank * n * n so n --> sqrt (time / rank)
        }

        //check if all cars can be repaired
        return repairedCars >= carsToRepair;
    }
}