class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(sb.length() > 0 && Math.abs(c - sb.charAt(sb.length()-1)) == 32){
                //this implies the current char and the last char are of opposite case
                sb.deleteCharAt(sb.length()-1); // remove the bad pair
            }else{
                sb.append(c);
            }  
        }
        return sb.toString();
    }
}