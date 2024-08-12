class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
        
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        
        //put the mapping in a map
        Map<Character, String> map = new HashMap<>();
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        result = new ArrayList<>();
        StringBuilder currStr = new StringBuilder();
        
        getCombinations(currStr, digits, 0, map);
        
        return result;
    }
    
    private void getCombinations(StringBuilder currStr, String digits, int currDigitIndex, Map<Character, String> map){
        
        //base case 
        //when we have processed all digits then return
        if(currDigitIndex == digits.length()){
            result.add(currStr.toString());
            return;
        }
        
        char currDigit = digits.charAt(currDigitIndex);
        String currDigitStr = map.get(currDigit);
        //System.out.println(currDigitStr);
        
        for(int i=0; i<currDigitStr.length(); i++){
            currStr.append(currDigitStr.charAt(i));
            //combine this with every character of second digit
            getCombinations(currStr, digits, currDigitIndex + 1, map); //go and combine with rest of the digits string
            currStr.deleteCharAt(currStr.length()-1);
        }
    }
}