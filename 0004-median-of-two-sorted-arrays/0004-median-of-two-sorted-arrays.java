class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // we need to have elements from array1 and array2 figured out so that we know what can be the median
        // to have the elements sorted from both arrays we can decide how many elements from first array and how many elements from second array would be on left and right
        //since we apply binary search to know how many elements from nums1 will be picked we do BS on smaller array
        int n1 = nums1.length;
        int n2 = nums2.length;
        int totalSize = n1 + n2;

        if(n1 > n2){
           return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1; //smaller array size as max we can take all elements from nums1

        while(low <= high){
            int mid1 = (low + high)/2; //this will give how many elements from first array we will take
            int mid2 = (totalSize + 1)/2 - mid1; //number of elements from mid2

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];

            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            double median = 0.0;

            if(l1 <= r2 && l2 <= r1){
                return median = (totalSize%2 == 0) ? (Math.max(l1, l2) + Math.min(r1, r2))/2.0 : Math.max(l1,l2);
            }else if(l1 > r2){
                high = mid1 - 1;
            }else {
                low = mid1 + 1;
            }
        }

        return 0.0;  
    }
}