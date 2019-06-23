package L852山脉数组的峰顶索引;

public class Solution {
	
	/*
	public int peakIndexInMountainArray(int[] A) {
		if(A.length==0)	return 0;
        for(int i=1; i<A.length; i++) {
        	if(A[i-1] < A[i] && A[i] > A[i+1]) {
        		return i;
        	}
        }
		return 0;
    }
    */
	
	public int peakIndexInMountainArray(int[] A) {
		if(A.length==0)	return 0;
		int i=0, j=A.length-1;
		while(i != j) {
			if (i < j && A[i] < A[i + 1]) {
				i++;
			}
			if (i < j && A[j] < A[j - 1]) {
				j--;
			}
		}
		if(i == j)	return i;
		return 0;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {3,4,5,1};
//		int[] A = {0,2,1,0};
		int n = solution.peakIndexInMountainArray(A);
		System.out.println(n);
	}

}
