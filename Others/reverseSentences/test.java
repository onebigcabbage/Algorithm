package reverseSentences;

public class test {
	
	private static void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	
	private static String reverseSen(String str) {
		if (str == null || str.length() == 0)
			return str;
		char[] ans = str.toCharArray();
		reverse(ans, 0, ans.length - 1);
		System.out.println(new String(ans));
		
		int start = 0, end = 0;
		while (end < ans.length) {
			if (end == ans.length - 1 || ans[end] == ' ') {
				reverse(ans, start, end - 1);
				start = end + 1;
			}
			end++;
		}
		
		System.out.println(new String(ans));
		
		return new String(ans);
	}

	public static void main(String[] args) {
		String str = "I am a student.";
		reverseSen(str);
	}

}
