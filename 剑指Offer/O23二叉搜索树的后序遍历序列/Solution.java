package O23二叉搜索树的后序遍历序列;

public class Solution {
	
	public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
			return false;
		}
        if (sequence.length == 1) {
			return true;
		}
        return midSearch(sequence, 0, sequence.length-1);
    }

	public boolean midSearch(int[] sequence, int left, int right) {
		if (left >= right) {
			return true;
		}
		int i = left;
		while (sequence[i] < sequence[right]) {
			i++;
		}
		for (int j = i; j < right; j++) {
			if (sequence[j] < sequence[right]) {
				return false;
			}
		}
		return midSearch(sequence, left, i - 1) && midSearch(sequence, i + 1, right - 1);
	}

}
