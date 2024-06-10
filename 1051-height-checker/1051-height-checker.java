class Solution {
    public int heightChecker(int[] heights) {
        Integer[] newArr = Arrays.stream(heights).boxed().toArray(Integer[]::new);
        List<Integer> list = new ArrayList<>(Arrays.asList(newArr));
        Collections.sort(list);
        int count = 0;
        
        for(int i=0; i<heights.length; i++){
            if(heights[i] != list.get(i)){
                count++;
            }
        }
        
        return count;
    }
}