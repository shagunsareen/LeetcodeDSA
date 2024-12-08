public class Solution {

    public boolean canChange(String start, String target) {        
        int startIndex = 0;
        int targetIndex = 0;
        
        while(startIndex < start.length() || targetIndex < target.length()){
                //skip underscore 
            while(startIndex < start.length() && start.charAt(startIndex) == '_'){
                startIndex++;
            }
            while(targetIndex < target.length() && target.charAt(targetIndex) == '_'){
                targetIndex++;
            }

           // If one string is exhausted, both should be exhausted
            if(startIndex == start.length() || targetIndex == target.length()){
                return startIndex == start.length() && targetIndex == target.length();
            }

            //now that we have reached chars 
            if(start.charAt(startIndex) != target.charAt(targetIndex) ||
              start.charAt(startIndex) == 'L' && startIndex < targetIndex ||
              target.charAt(targetIndex) == 'R' && startIndex > targetIndex){
                return false;
            }

            //else if all conditions are fine then increment start and target index 
            startIndex++;
            targetIndex++;
        }
        
        return true;
    }
}