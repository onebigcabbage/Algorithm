package O37数字在排序数组中出现的次数;

public class Solution {
	
	/**
	 * 
	 * 寻找 k 第一个出现的索引
	 */
	private static int getFirstK(int[] array, int k, int i, int j) {
		if (i > j) {
			return -1;
		}
		int middle = (i + j) / 2;
		// 中间数字刚好等于 k，但是不确定是第一个出现的 k
		if (array[middle] == k) {
			// 若前面数字不等于 k，说明此中间数字是第一个出现的 k
			if (middle == 0 || (middle > 0 && array[middle - 1] != k)) {
				return middle;
				// 前面数字等于 k,查找数组前半段
			} else {
				j = middle - 1;
			}
			// 查找数组后半段
		} else if (array[middle] > k) {
			j = middle - 1;
			// 查找数组前半段
		} else {
			i = middle + 1;
		}
		return getFirstK(array, k, i, j);
	}
	
	/**
	 * 
	 * 寻找 k 最后一个出现的索引
	 */
	private static int getLastK(int[] array, int k, int i, int j) {
		if (i > j) {
			return -1;
		}
		int middle = (i + j) / 2;
		if (array[middle] == k) {
			if (middle == array.length - 1 || (middle < array.length - 1 && array[middle + 1] != k)) {
				return middle;
			} else {
				i = middle + 1;
			}
		} else if (array[middle] > k) {
			j = middle - 1;
		} else {
			i = middle + 1;
		}
		return getLastK(array, k, i, j);
	}


	public static int GetNumberOfK(int[] array, int k) {
		if (array.length == 0) {
			return 0;
		}
		int first = getFirstK(array, k, 0, array.length - 1);
		int last = getLastK(array, k, 0, array.length - 1);
		if (first != -1 && last != -1) {
			return last - first + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 3, 3 };
		int n = GetNumberOfK(array, 3);
		System.out.println(n);
	}

}
