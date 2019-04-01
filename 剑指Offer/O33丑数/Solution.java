package O33丑数;

import java.util.Arrays;

public class Solution {
	
	/*
	// 方法一
    public static int GetUglyNumber_Solution(int index) {
    	if (index <= 0)
    		return 0;
    	int count = 0, number = 0;
    	while (count < index) {
    		number++;
    		if (isUgly(number)) {
    			count++;
    		}
    	}
    	System.out.println(number);
        return number;
    }
    
    private static boolean isUgly(int number) {
    	while (number % 2 == 0) {
    		number /= 2;
    	}
    	while (number % 3 == 0) {
    		number /= 3;
    	}
    	while (number % 5 == 0) {
    		number /= 5;
    	}
    	return (number == 1) ? true : false;
	}
    */
	
	// 方法二
	public static int GetUglyNumber_Solution(int index) {
		if (index <= 0)
    		return 0;
		int[] res = new int[index];
		res[0] = 1;
		int l1 = 0, l2 = 0, l3 = 0;
		for (int i = 1; i < index; i++) {
			res[i] = findMin(res[l1] * 2, res[l2] * 3, res[l3] * 5);
			if (res[i] == res[l1] * 2)
				l1++;
			if (res[i] == res[l2] * 3)
				l2++;
			if (res[i] == res[l3] * 5)
				l3++;
		}
		System.out.println(res[index - 1]);
		return res[index - 1];
    }
    
    
	private static int findMin(int i, int j, int k) {
		int min = Math.min(i, j);
		return Math.min(min, k);
	}


	public static void main(String[] args) {
    	GetUglyNumber_Solution(7);
	}
    
}
