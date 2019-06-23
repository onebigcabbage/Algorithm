package L832翻转图像;

public class Solution {
	
	/* 法一
	public int[][] flipAndInvertImage(int[][] A) {
		if (A == null)
			return null;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0, k = A[0].length - 1; j < k; j++, k--) {
				int temp = A[i][j];
				A[i][j] = A[i][k];
				A[i][k] = temp;
			}
			for (int l = 0; l < A[i].length; l++) {
				A[i][l] ^= 1;
			}
		}
		return A;
    }
    */
	
	public int[][] flipAndInvertImage(int[][] A) {
		if (A == null)
			return null;
		for (int[] value : A) {
			for (int j = 0; j <= value.length / 2; j++) {
				int temp = value[j];
				value[j] = value[value.length - 1 - j];
				value[value.length - 1 - j] = temp;
			}
			for (int l = 0; l < value.length; l++) {
				value[l] ^= 1;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] A = {{1,1,0},{1,0,0},{0,1,1},{1,0,1}};
		solution.flipAndInvertImage(A);
	}

}
