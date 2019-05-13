package O43左旋转字符串;

public class Solution {

	public static String LeftRotateString(String str, int n) {
		if (str == null || str.length() == 0)
			return str;
		char[] ans = str.toCharArray();
		reverse(ans, 0, n - 1);
		reverse(ans, n, ans.length - 1);
		reverse(ans, 0, ans.length - 1);
		System.out.println(new String(ans));
		return new String(ans);
	}

	private static void reverse(char[] ans, int i, int j) {
		while (i < j) {
			char temp = ans[i];
			ans[i] = ans[j];
			ans[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		LeftRotateString("abcXYZdef", 3);
	}

}
