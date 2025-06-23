class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        int i=0;
        int n = s.length();

        while(i+k <= n){
            res.add(s.substring(i,i+k));
            i += k; 
        }
        
        //if we dont have last string as k length append x to it 
        if(i < n){
            StringBuilder last = new StringBuilder(s.substring(i)); //take entire last string
            int diff = k - last.length();

            for(int j=0; j<diff; j++){ //append x to the string
                last.append(fill);
            }
            res.add(last.toString());
        }

        return res.toArray(new String[0]);
    }
}