class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        
        //store characters of subtring in set
        HashSet<Character> set = new HashSet<>();
        
        int start = 0;
        int n = s.length();
        int end = 0;
        int maxLength = Integer.MIN_VALUE;
        
        while(start<=end && end<n){
            char ch = s.charAt(end);
            if(!set.contains(ch)){
                set.add(ch);
                end++;
                maxLength = Math.max(maxLength, set.size());
                System.out.println("End : " +end + ", ML : "+maxLength);
            }else{   
                while(set.contains(ch)){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(ch);
                end++;
            }  
        }
        return maxLength;
    }
}