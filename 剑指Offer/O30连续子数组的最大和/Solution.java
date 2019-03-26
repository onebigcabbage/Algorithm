package O30连续子数组的最大和;

public class Solution {
	
	/*
    public static int FindGreatestSumOfSubArray(int[] array) {
    	int maxsum = 0, thissum = 0;
		for (int i = 0; i < array.length; i++) {
			thissum += array[i];
			maxsum = thissum > maxsum ? thissum : maxsum;
			thissum = thissum < 0 ? 0 : thissum;
		}
		System.out.println(maxsum);
		return maxsum;
    }
    */
    
    public static int FindGreatestSumOfSubArray(int[] array) {
		int maxsum = array[0], thissum = array[0];
		for (int i = 1; i < array.length; i++) {
			thissum = Math.max(array[i], thissum + array[i]);
			maxsum = Math.max(maxsum, thissum);
		}
		System.out.println(maxsum);
		return maxsum;
	}

    
    
    public static void main(String[] args) {
    	int[] array = { 6, -3, -2, 7, -15, 1, 2, 2 };
		FindGreatestSumOfSubArray(array);
    }
    
}
