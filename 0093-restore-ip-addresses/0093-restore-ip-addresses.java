class Solution {
    /*public List<String> restoreIpAddresses(String s) {
       List<String> result = new ArrayList<>();
        backtrack(s, result, 0, "", 0);
        return result;
    }
    
    private void backtrack(String s, List<String> result, int index, String current, int segment) {
        if (segment == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1)); // Remove the last dot
            return;
        }
        
        if (segment == 4 || index == s.length()) {
            return;
        }
        
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;
            
            String part = s.substring(index, index + len);
            if (isValid(part)) {
                backtrack(s, result, index + len, current + part + ".", segment + 1);
            }
        }
    }
    
    private boolean isValid(String part) {
        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }
        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }*/
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        StringBuilder ip = new StringBuilder();
        
        for(int aLen=1; aLen<=3; aLen++){
            for(int bLen=1; bLen<=3; bLen++){
                for(int cLen=1; cLen<=3; cLen++){
                    
                    int dLen = length - aLen - bLen - cLen;
                    
                    //check if d is not greater than 3
                    if(dLen>0 && dLen<=3){
                        String A = s.substring(0, aLen);
                        String B = s.substring(aLen, aLen+bLen);
                        String C = s.substring(aLen+bLen, aLen+bLen+cLen);
                        String D = s.substring(aLen+bLen+cLen);

                        //check if the string is valid of not
                        if(isValid(A) && isValid(B) && isValid(C) && isValid(D)){
                            ip.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                            res.add(ip.toString());
                        }

                        ip = new StringBuilder();
                    }   
                }
            }
        }
        return res;
    }
    
    
    private boolean isValid(String part){
        if(part.length() > 1 && part.startsWith("0")){
            return false;
        }
        
        int value = Integer.parseInt(part);
        return value>=0 && value<=255;
    }

}