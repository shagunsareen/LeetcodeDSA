class Solution {
    public String reorganizeString(String s) {

        //step1 : count frequency of each character 
        int[] freq = new int[26];
        
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        //step2 : insert to queue with freq, sorted by decreasing order in frequency
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[1], a[1]));
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                pq.offer(new int[]{i + 'a', freq[i]});
            }    
        }

        //step3 : pick highest frequency character first and skip same character as that of prev 
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            char currCh = (char) curr[0];
            int currFreq = curr[1];

            // append char if no prev char is there else when prev is not same as curr
            if(sb.length() == 0 || currCh != sb.charAt(sb.length()-1)){

                sb.append(currCh);
                curr[1]  = curr[1] - 1;

                if(curr[1] > 0){
                    pq.offer(curr);
                }
            }else{
                if(pq.isEmpty()){
                    return ""; 
                }

                int[] next = pq.poll();
                char nextCh = (char) next[0];
                int nextFreq = next[1];

                sb.append(nextCh);
                next[1]  = next[1] - 1;

                if(next[1] > 0){
                    pq.offer(next);
                }

                pq.offer(curr); //since we didn't use this 
            }
        }
        return sb.toString();
    }
}