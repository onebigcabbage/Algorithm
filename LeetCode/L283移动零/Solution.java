package L283移动零;

public class Solution {
	
	/**
	 * 方法一
	 */
	public void moveZeroes(int[] nums) {
		// 数组中零的个数
		int count = 0;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i]==0) {
        		count++;
        	}else if(count!=0){
        		nums[i-count] = nums[i];
        		nums[i] = 0;
        	}
        }
    }
	
	/**
	 * 方法二：
	 * 如果当前数字不为零，就放到前面
	 * 将最后剩下的几个置位零。
	 * 
	public void moveZeroes(int[] nums) {
		int j = 0;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i]!=0) {
        		nums[j++] = nums[i];
        	}
        }
        while(j<nums.length) {
        	nums[j++] = 0;
        }
		for (int i : nums) {
			System.out.println(i);
		}
    }
    */

	public static void main(String[] args) {
//		int[] nums = {0,1,0,3,12};
//		int[] nums = {0,0,1};
		int[] nums = {1};
		Solution solution = new Solution();
		solution.moveZeroes(nums);
	}

}
