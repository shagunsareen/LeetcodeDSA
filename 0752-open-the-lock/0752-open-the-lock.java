class Solution {
    public int openLock(String[] deadends, String target){ 
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>(Collections.singletonList("0000"));
        int level = -1;
         while(!q.isEmpty()) {
            level++;
            int size = q.size();
            for(int i = 0; i<size; i++){
                String curr = q.poll(); //delete the front ele of the queue
                if(curr.equals(target))
                    return level;
                if(visited.contains(curr))
                    continue;
                //if it is not visited then put it into visited list 
                visited.add(curr);
                q.addAll(getSuccessors(curr));
            } 
        }  
        return -1;
    }
    
    
    private List<String> getSuccessors(String str) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 :  str.charAt(i) - '0' - 1) + str.substring(i+1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 :  str.charAt(i) - '0' + 1) + str.substring(i+1));
        }
        return res;
    }
}