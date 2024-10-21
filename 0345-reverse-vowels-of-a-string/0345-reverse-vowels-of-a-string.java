class Solution {
    public String reverseVowels(String s) {
        int p1 = 0;
        int p2 = s.length()-1;
        
        if(s.length() == 1){
            return s;
        }
        
        StringBuilder str = new StringBuilder(s);
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i'); 
        set.add('o'); 
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I'); 
        set.add('O'); 
        set.add('U');

        while(p1<p2){
            
            while(p1<p2 && !set.contains(str.charAt(p1))){
                p1++;
            }
            
            while(p1<p2 && !set.contains(str.charAt(p2))){
                p2--;
            }
            
            
            //swap the vowels
            char leftChar = str.charAt(p1);
            char rightChar = str.charAt(p2);
            
            str.setCharAt(p1, rightChar);
            str.setCharAt(p2, leftChar); 
            
            p1++;
            p2--;
        }
        
        return str.toString();
    }
}