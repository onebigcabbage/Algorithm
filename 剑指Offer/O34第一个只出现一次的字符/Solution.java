package O34第一个只出现一次的字符;

import java.util.HashMap;

public class Solution {
	
	public static int FirstNotRepeatingChar(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char key = str.charAt(i);
			if (!map.containsKey(key)) {
				map.put(key, 1);
			}else {
				int count = map.get(key);
				map.put(key, ++count);
			}
		}
		int pos = -1;
		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i)) == 1)	
				return i;
		}
        return pos;
    }
	
	public static void main(String[] args) {
		int pos = FirstNotRepeatingChar("abcdefabcdf");
		System.out.println(pos);
	}

}
