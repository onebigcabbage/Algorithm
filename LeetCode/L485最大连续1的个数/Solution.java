package L485最大连续1的个数;

public class Solution {
	
	public int findMaxConsecutiveOnes(int[] nums) {
		int count=0, flag = 0;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i]==1) {
        		flag++;
        	}else {
        		count = Math.max(count, flag);
        		flag = 0;
        	}
        }
//        System.out.println(Math.max(count, flag));
		return Math.max(count, flag);
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {1,1,0,1,1,1};
		sol.findMaxConsecutiveOnes(nums);
	}

}
