class Solution {
    public String minWindow(String s, String t) {
        
        if(t.isEmpty()) return "";
        //find valid window first then minimize it to get smallest valid window
        //we count window as valid when we have count of characters which are expected in t string
        //once we have that we shrink window to get short valid window

        int sLen = s.length();
        int tLen = t.length();

        //since we have lower and uppercase characters we cant take int[], so we take map
        Map<Character, Integer> tcount = new HashMap<>();
        for(char ch : t.toCharArray()){
            tcount.put(ch, tcount.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> scount = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int have = 0;
        int need = tcount.size();
        int[] res = {-1, -1};

        for(int end = 0; end < sLen; end++){

            char ch = s.charAt(end);
            scount.put(ch, scount.getOrDefault(ch, 0) + 1);

            //check if we have met the freq of this char as that of t 
            if(tcount.containsKey(ch) && tcount.get(ch).equals(scount.get(ch))){
                have++;
            }

            while(have == need){
                //update len
                if(end - start + 1 < minLen){
                    minLen = end - start + 1;
                    res[0] = start;
                    res[1] = end;
                } 
               
                //shrink window
                char leftCh = s.charAt(start);
                scount.put(leftCh, scount.get(leftCh) - 1);

                if(tcount.containsKey(leftCh) && tcount.get(leftCh) > scount.get(leftCh)){
                    have--;
                }
                start++;
            }
        }

        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1); 

       /* if (t.isEmpty()) return "";

        //take freq of t in one map
        //check s chars till we get all t chars , once we get take len and shrink window then by moving left pointer
        Map<Character, Integer> tcount = new HashMap<>();
        for(char ch : t.toCharArray()){
            tcount.put(ch, tcount.getOrDefault(ch, 0) + 1);
        }

        int need = tcount.size();
        int have = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        Map<Character, Integer> scount = new HashMap<>();
        int[] res = {-1,-1};

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            scount.put(ch, scount.getOrDefault(ch, 0) + 1);

            //check if this char is in t and if freq is same
            if(tcount.containsKey(ch) && tcount.get(ch).equals(scount.get(ch))){
                have++;
            }

            //when we have got all the required characters then take len and shrink window
            while(have == need){
                //update len 
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                //shrink
                char leftCh = s.charAt(left);
                scount.put(leftCh, scount.get(leftCh) - 1);
                if(tcount.containsKey(leftCh) && tcount.get(leftCh) > scount.get(leftCh)){
                    have--;
                }
                left++;
            }

        }

        return res[0] == -1 ? "" : s.substring(res[0], res[1]+1); */
    }
}