/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /*private int numofPeople;

    //Approach - O(n2) as every node makes 2 api calls with other n-1 nodes. so for total n nodes this is O(n2)
    public int findCelebrity(int n) {
        numofPeople = n;
        for(int i=0; i<n; i++){
            if(isCelebrity(i)){
                return i;
            }
        }
        return -1;
    }

    private boolean isCelebrity(int i){
        for(int j=0; j<numofPeople; j++){
            if(i==j) continue;
            if(knows(i, j) || !knows(j,i)){
                return false;
            }
        }
        return true;
    }*/
    private int numofPeople;

    public int findCelebrity(int n) {
        numofPeople = n;
        int potentialCelebrity = 0;

        for(int i=0; i<n; i++){
            if(knows(potentialCelebrity, i)){ //check if potential ans knows next person if yes then update potential ans as previous one wont be the ans
                potentialCelebrity = i;
            }
        }

        //check for last potential ans whether actually it is celebrity or not
        if(isCelebrity(potentialCelebrity)){
            return potentialCelebrity;
        }
        return -1;
    }

    private boolean isCelebrity(int i){
        for(int j=0; j<numofPeople; j++){
            if(i==j) continue;
            if(knows(i, j) || !knows(j,i)){
                return false;
            }
        }
        return true;
    }
}