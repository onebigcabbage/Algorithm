package L053最大子序和;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Solution {

	/**
	 * 
	 * 暴力法
	 * 提交显示超时。
	 *	
	public int maxSubArray(int[] nums) {
		int maxcount = nums[0];
		int sum;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				maxcount = maxcount > sum ? maxcount : sum;
			}
		}
		System.out.println(maxcount);
		return maxcount;
    }
    */
	
	
	/**
	 * 
	 * 设 sum[i-1] 是以第i-1个元素结尾的最大子序和,
	 * 在第i个元素时有两种选择：加上第i个元素 或者 加上第i个元素后更小了，则只保存第i个元素，即：
	 * 		sum[i] = max(sum[i-1]+nums[i], nums[i])
	 *
	public int maxSubArray(int[] nums) {
		if(nums.length<=0)	return nums[0];
		int maxcount = nums[0];
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = (sum[i-1]+nums[i]) > nums[i] ? (sum[i-1]+nums[i]) : nums[i];
			maxcount = sum[i] > maxcount ? sum[i] : maxcount;
		}
		return maxcount;
    }
    */
	
	
	public int maxSubArray(int[] nums) {
		int sum = nums[0];
		int n = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (n > 0) {
				n += nums[i];
			} else {
				n = nums[i];
			}
			System.out.println(n);
			if (sum < n)
				sum = n;
		}
		System.out.println(sum);
		return sum;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { -2, 1, -3, 2, -1, 4, 1, -5, 4 };
//		int[] nums = {0};
		solution.maxSubArray(nums);
	}

}
