class Solution {
    
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {        

        Arrays.sort(tasks);
        Arrays.sort(workers);

        //binary search on answer, we will try to get max count of completed tasks. search space would lie between 0 to min(tasks.len, worker.len)
        int low = 0;
        int high = Math.min(tasks.length, workers.length);
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(canAssign(mid, tasks, workers, pills, strength)){
                ans = mid;
                low = mid + 1; //go and see next potential answer 
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canAssign(int mid, 
                              int[] tasks,
                              int[] workers,
                              int pills, 
                              int strength)
    {
        TreeMap<Integer, Integer> usableWorkers = new TreeMap<>();
        int n = workers.length;

        //we will have to consider strong workers from the end of the list
        for(int i = n-mid; i < n; i++){
            usableWorkers.put(workers[i], usableWorkers.getOrDefault(workers[i], 0) + 1);
        }

        //perform all tasks 
        for(int taskIndex = mid - 1; taskIndex >= 0; taskIndex--){
            int task = tasks[taskIndex]; 
            Integer currWorker = usableWorkers.lastKey();

            if(currWorker < task){         
                if(pills <= 0){
                    return false;
                }

                //can use pill
                //task needs suppose 7 , pill has strength 3 then worker strength needed is 4 , check in treeset if 4 is present or smallest number greater than 4 i.e. ceiling 
                currWorker = usableWorkers.ceilingKey(task - strength);
                if(currWorker == null){
                    return false;
                }   
                usableWorkers.put(currWorker, usableWorkers.get(currWorker) - 1);
                if(usableWorkers.get(currWorker) == 0){
                    usableWorkers.remove(currWorker);
                }
                 pills--;
            }else{
                usableWorkers.put(currWorker, usableWorkers.get(currWorker) - 1);
                if(usableWorkers.get(currWorker) == 0){
                    usableWorkers.remove(currWorker);
                }
            }
        }
        return true;
    }
}