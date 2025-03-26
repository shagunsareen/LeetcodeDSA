class Solution {
    public int minOperations(int[][] grid, int x) {   
        // min steps would be if we make every element as median , to get median we should sort array first
        // to sort the array we need to convert 2d array to 1d array
        List<Integer> arr = new ArrayList<>();

        //all elements can be made to one element if all elements % x gives same number then only we can have x multiple operations to reach common element
        int remainder = grid[0][0] % x;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] % x != remainder){
                    return -1;
                }
                arr.add(grid[i][j]);
            }
        }

        Collections.sort(arr);

        int medianIndex = arr.size()/2;

        // one element will reach median by knowing how much difference is in both numbers and then dividing by x 
        int steps = 0;
        for(int num : arr){
            steps += Math.abs(num - arr.get(medianIndex)) / x;
        }

        return steps;
    }
}