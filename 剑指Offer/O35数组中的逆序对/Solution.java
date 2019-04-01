package O35数组中的逆序对;

public class Solution {

	/*
	private static int InversePairs(int[] array) {
		int P = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					P++;
				}
			}
		}
		return P % 1000000007;
	}*/
	
	private static int InversePairs(int[] array) {
		int P = 0;
		
		return P % 1000000007;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 0 };
		int n = InversePairs(array);
		System.out.println(n);
	}

}
