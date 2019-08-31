package AllRange;

public class Solution {

	private static void allRange(char[] arr) {
		permutation(arr, 0, arr.length - 1);
	}
	
	private static void permutation(char[] arr, int start, int len) {
		if (start == len) {
			System.out.println(String.valueOf(arr));
		}else {
			for (int cur = start; cur <= len; cur++) {
				if (isSwap(arr, start, cur)) {
					swap(arr, start, cur);
					permutation(arr, start + 1, len);
					swap(arr, start, cur);					
				}
			}
		}
	}

	private static boolean isSwap(char[] arr, int start, int cur) {
		for (int i = start; i < cur; i++) {
			if (arr[i] == arr[cur]) {
				return false;
			}
		}
		return true;
	}

	// 若
	private static void swap(char[] arr, int i, int k) {
		if (i != k) {
			char c = arr[i];
			arr[i] = arr[k];
			arr[k] = c;
		}
	}

	public static void main(String[] args) {
		String str = "122";
		allRange(str.toCharArray());
	}


}