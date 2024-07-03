class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 0;  
        
        Set<String> set = new HashSet<>(wordList);    //wordsList 
        if(!set.contains(endWord)) return 0;
        //System.out.println(set.size());
        
        int count = 0;
        Queue<String> queue = new LinkedList<>(); //BFS since we have to find shortest transformation sequence
        queue.add(beginWord);
            
        while(!queue.isEmpty()){ 
            int size = queue.size();  
            
            for(int i=0; i<size; i++)
            {
                String currWord = queue.poll();
                
                if(currWord.equals(endWord))
                    return count+1;
                
                StringBuilder curr = new StringBuilder(currWord);
               
                
                for(int j=0; j<curr.length(); j++)
                {   //change each char in this word and check if the new combination is in wordList 
                    char old = curr.charAt(j); 
                     //System.out.println(old);
                    for(char ch='a'; ch<='z'; ch++)
                    {
                        if(ch!=old){
                            curr.setCharAt(j, ch); //replace jth char with this character
                            
                            if(set.contains(curr.toString()))
                            {
                                //System.out.println("Set contains : " +curr.toString());
                                queue.add(curr.toString());
                                set.remove(curr.toString()); //because we dont want to iterate on the same word again
                            }
                        }     
                    }
                    curr.setCharAt(j,old); //put the original char back
                }
            }
            count++;
        }       
        return 0;
    }
}