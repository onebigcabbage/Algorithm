package O32把数组排成最小的数;

import java.math.BigInteger;

public class Solution {
	
    public static String PrintMinNumber(int [] numbers) {
    	if (numbers.length == 0)
    		return "";
    	String str = "";
        for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				BigInteger a = new BigInteger(numbers[j] + "" + numbers[j + 1]);
				BigInteger ra = new BigInteger(numbers[j + 1] + "" + numbers[j]);
				if (a.compareTo(ra) == 1) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
			
		}
        for (int i = 0; i < numbers.length; i++) {
			str += String.valueOf(numbers[i]);
		}
	     System.out.println(str);
	     return str;
    }
    
    public static void main(String[] args) {
		int[] nums = { 35, 1, 4, 2 };
//		int[] nums = { 3334, 3, 3333332 };
		PrintMinNumber(nums);
	}
    
}