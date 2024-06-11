class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxElement = Arrays.stream(arr1).max().orElse(0);
        int count[] = new int[maxElement+1];
        
        //store the frequency of every element of arr1 in this 
        for(int element : arr1){
            count[element]++;
        }
        
        //now for each element in arr2, consider the order of element and insert it as per count frequency in result list 
        
        for(int element : arr2){
            while(count[element] > 0){
                result.add(element);
                count[element]--;
            }
        }
        
        //now only the remaining elements are left, add them in ascending order
        for(int num=0; num <= maxElement; num++){
            while(count[num] > 0){
                result.add(num);
                count[num]--;
            }
        }
        
        //convert arraylist to array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}