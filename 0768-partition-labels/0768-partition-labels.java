class Solution {
    public List<Integer> partitionLabels(String s) {
        //get last occurrance of each character as we need to include it in partition
        int[] lastOccurance = new int[26];
        for(int i=0; i<s.length(); i++){
            lastOccurance[s.charAt(i) - 'a'] = i;
        }

        int partitionStart = 0;
        int partitionEnd = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            int lastIndex = lastOccurance[s.charAt(i) - 'a'];
            partitionEnd = Math.max(lastIndex, partitionEnd); // if till now partitionEnd is 2 but curr characters last index is at 4 then we cant end this partition before that so we need to update partitionEnd to the lastIndex 4 

            if(i == partitionEnd){ //new partition begins 
                result.add(i - partitionStart + 1);
                partitionStart = i + 1;
                partitionEnd = 0;
            }
        }
        return result;
    }
}