class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minRotations = Integer.MAX_VALUE;
        int topCount = Integer.MAX_VALUE;
        int bottomCount = Integer.MAX_VALUE;

        for(int i=1; i<=6; i++){
            topCount = countRotations(i, tops, bottoms);
            if(topCount != Integer.MAX_VALUE){ //ensuring bottom check might give result
                bottomCount = countRotations(i, bottoms, tops);
            }
            minRotations = Math.min(minRotations, Math.min(topCount, bottomCount));
        }
        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
    }

    private int countRotations(int curr, int[] first, int[] second){
        int count = 0;
        for(int j=0; j<first.length; j++){
            if(first[j] == curr) continue;
            else if(second[j] == curr) count++;
            else return Integer.MAX_VALUE; //not possible
        }
        return count;
    }
}