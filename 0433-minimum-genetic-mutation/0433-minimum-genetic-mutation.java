class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Set<String> set = new HashSet<>(Arrays.asList(bank));  //first step is to put all the bank strings to set so that we can check whether new mutations  are present or not 
        if(!set.contains(endGene)){ //check if the target gene is present in bank or not -- negative scenario
            return -1;
        }
        
        char[] ch = new char[]{'A', 'C', 'G', 'T'};  //if it contains then we can start from startGene and change each char with valid ones
        
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        
        int level = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0 ;i<size; i++){
                
                String currGene = queue.poll();
                if(currGene.equals(endGene))   //check if this is equal to endGene
                    return level; 
                
                StringBuilder currBuilder = new StringBuilder(currGene);

                for(int j=0; j<currBuilder.length(); j++){ //if it is not then we mutate to convert it to endGen      
                    char temp = currBuilder.charAt(j); //to restore to original state 
                    for(char c: ch){
                        if(c!=temp){
                             currBuilder.setCharAt(j,c);
                        }  
                        if(set.contains(currBuilder.toString())){  //check if this is in bank or not
                            queue.add(currBuilder.toString());
                            set.remove(currBuilder.toString());
                        }
                    }
                    currBuilder.setCharAt(j, temp); //restoring the original string
                }
            }
            level++;
        }
        
        return -1;
    }
}