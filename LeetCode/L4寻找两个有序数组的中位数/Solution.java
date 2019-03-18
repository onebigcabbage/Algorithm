class Solution {

    // 方法一
    /*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, count = 0;
        int[] nums = new int[m+n];

        if(m == 0 && n == 0){
            return 0.0;
        }
        if(m == 0){
            if(n % 2 == 0){
                return (nums2[n/2-1] + nums2[n/2]) / 2.0;
            }else{
                return nums2[n/2];
            }
        }
        if(n == 0){
            if(m % 2 == 0){
                return (nums1[m/2-1] + nums1[m/2]) / 2.0;
            }else{
                return nums1[m/2];
            }
        }

        while(count != (m+n)){
            if(i == m){
                while(j != n){
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if(j == n){
                while(i != m){
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if(nums1[i] <= nums2[j]){
                nums[count++] = nums1[i++];
            }else{
                nums[count++] = nums2[j++];
            }
        }

        if(count % 2 == 0){
            return (nums[count/2-1] + nums[count/2]) / 2.0;
        }else{
            return nums[count/2];
        }
        
    }
    */

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {1, 2, 3, 5, 6, 7};
        double n = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println(n);
    }
}