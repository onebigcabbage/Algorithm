package L7171比特与2比特字符;

public class Solution {
	
	/**
	 * 根据题意，给定的字符串总是由0结束。所以去除前面的比特字符后的形式：[...,0]和[...,1,0]，其中第二种是false。
	 * 设置一个下标。
	 * 若当前数是1，那么下一个数是0或1，组合一块必定为一个一比特字符，所以下标加2，
	 * 若当前数是0，那么下标加1，
	 * 遍历到倒数第二位数，若最后得到的下标是最后一位数，则返回true，反之，false。
	 * 
	 */
	public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i<bits.length-1) {
        	i += bits[i] + 1;
        }
		return i == bits.length-1;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] bits = {1, 1, 1, 0};
		int[] bits = {0, 0, 1, 0};
		boolean sol = solution.isOneBitCharacter(bits);
		System.out.println(sol);
	}

}
