package L027移除元素;

public class Solution {
	
	public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j=0; j<nums.length; j++) {
        	if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
        }
        System.out.println(i);
		return i;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int nums[] = {0,1,2,2,3,0,4,2};
		int val = 2;
		solution.removeElement(nums, val );
	}

}
