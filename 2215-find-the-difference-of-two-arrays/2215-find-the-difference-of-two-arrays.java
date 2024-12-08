class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2), getElementsOnlyInFirstList(nums2, nums1));
    }
    
    private List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2){
        
        //put second array elements to set 
        Set<Integer> existsInNums2 = new HashSet<>();
        
        for(int num : nums2){
            existsInNums2.add(num);
        }
        
        //now check which elements of nums1 is not in set2, store those in set1
        Set<Integer> onlyInNums1 = new HashSet<>();
        for(int num : nums1){
            if(!existsInNums2.contains(num)){
                onlyInNums1.add(num);
            }
        }
        
        return new ArrayList<>(onlyInNums1);     
    }
    
    
}