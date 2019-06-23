package L905按奇偶排序数组;

public class Solution {
	
	public int[] sortArrayByParity(int[] A) {
		if(A.length==0) return A;
        int i = 0, j = A.length-1;
        while(i < j) {
        	while(i<j && A[i]%2==0) {
        		i++;
        	}
        	while(i<j && A[j]%2==1) {
        		j--;
        	}
        	int value = A[i];
        	A[i] = A[j];
        	A[j] = value;
        	i++;
        	j--;
        }
//        for(int a: A) {
//        	System.out.print(a);
//        }
		return A;
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {3,1,2,4};
		sol.sortArrayByParity(A);
	}

}