class Solution {
    public int minimumIndex(List<Integer> nums) {
        //step 1 : find majority element using moore's voting algo
        int majorityEle = nums.get(0); //assume 
        int currCount = 0; //this will determine if there are more elements in nums than majorityElement

        for(int num : nums){
            if(num == majorityEle){
                currCount++;
            }else{
                currCount--;
            }

            if(currCount == 0){
                //meaning other elements are more compared to the majorityElement so consider curr element as majorityelement
                majorityEle = num;
                currCount = 1; 
            }
        }

        //after this for loop we will get majorityElement but we need to double check whether its freq is actually more than all other elements

        //step2 : check the frequency of majority element
        int freq = 0;
        for(int num : nums){
            if(num == majorityEle){
                freq++;
            }
        }

        //step3 : check if valid split is possible with this majorityElement
        int prefixCount = 0;
        int n = nums.size();

        for(int i=0; i<n; i++){
            //we will check how many times curr majorityele occurs so that we can check if we split it at i index will it be me in both split arrays or not
            if(nums.get(i) == majorityEle){
                prefixCount++;
            }

            int remainingFreq = freq - prefixCount;
            //elements on left side of split are b-a+1 i.e. i-0+1 = i+1 
            //elements on right side of split are n-1-(i+1)+1 = n-i-1
            if(prefixCount * 2 > i + 1 && remainingFreq * 2 > n-i-1){
                return i; //valid split
            }
        }
        return -1;
    }
}