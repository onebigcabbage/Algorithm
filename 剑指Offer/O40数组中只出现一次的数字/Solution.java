package O40数组中只出现一次的数字;

public class Solution {

	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length <2)
			return;
		int length = array.length;
		int flag = 0;
		for (int i = 0; i < length; i++) {
			flag ^= array[i];
		}
		
		int index = findIndex(flag);
		
		num1[0] = 0;
		num2[0] = 0;
		for (int i = 0; i < length; i++) {
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
		System.out.println(num1[0] + " " + num2[0]);
		
	}


	private static boolean isBit1(int i, int index) {
		return ((i >> index) & 1) == 1;
	}


	private static int findIndex(int flag) {
		int index = 0;
		while ((flag & 1) == 0) {
			flag >>= 1;
			index++;
		}
		return index;
	}

	public static void main(String[] args) {
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		int[] num1 = { 0 };
		int[] num2 = { 0 };
		FindNumsAppearOnce(array, num1, num2);
	}

}
