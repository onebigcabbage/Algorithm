package L_709转换成小写字母;

public class Solution {

	public String toLowerCase(String str) {
        char[] value = str.toCharArray();
        for(int i=0; i<value.length; i++){
            if(value[i] >='A' && value[i]<='Z'){
            	// ways 1
                value[i] += 32;
            	// ways 2
//            	value[i] = (char) (value[i] + 'a' - 'A');
            }
        }
        return String.valueOf(value);
	}


	public static void main(String[] args) {
		Solution sol = new Solution();
		String str = "HellO";
		sol.toLowerCase(str);
	}

}
