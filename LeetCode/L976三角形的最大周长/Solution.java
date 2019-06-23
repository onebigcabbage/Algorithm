package L976三角形的最大周长;

import java.util.Arrays;

public class Solution {
	
	public int largestPerimeter(int[] A) {
		if(A.length<3)	return 0;
        Arrays.sort(A);
        for(int i=A.length-3; i>=0; i--) {
        	if(A[i] + A[i+1] > A[i+2]) {
        		return A[i] + A[i+1] + A[i+2];
        	}
        }
        return 0;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {3,6,2,3};
		int n = solution.largestPerimeter(A);
		System.out.println(n);
	}

}
