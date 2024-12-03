class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder strB = new StringBuilder();
        int spaceIndex = 0;
        int n = spaces.length;
        
        for(int i=0; i<s.length(); i++){
           
            if(spaceIndex < n && spaces[spaceIndex] == i){
                strB.append(' ');
                spaceIndex++;
            }
            strB.append(s.charAt(i)); 
            
        }
        
        return strB.toString();
    }
}