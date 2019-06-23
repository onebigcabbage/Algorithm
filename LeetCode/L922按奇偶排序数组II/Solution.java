package L922按奇偶排序数组II;

public class Solution {
	
	/*
	public int[] sortArrayByParityII(int[] A) {
        if(A.length==0) return A;
        int i = 0, j = A.length-1;
        while(i < j) {
        	while(i<j && ((i%2==1 && A[i]%2==1) || (i%2==0 && A[i]%2==0))) {
        		i++;
        	}
        	while(i<j && ((j%2==1 && A[j]%2==1) || (j%2==0 && A[j]%2==0))) {
        		j--;
        	}
        	int temp = A[i];
        	A[i] = A[j];
        	A[j] = temp;
//        	i++;
//        	j--;
        }
        for(int a: A) {
        	System.out.print(a);
        }
		return A;
    }
    */
	
	public int[] sortArrayByParityII(int[] A) {
        if(A.length==0) return A;
        int i = 0, j = 1, len = A.length;
        while(i < len && j < len) {
        	while(i<len && (A[i]&0x1)==0) {
        		i += 2;
        	}
        	while(j<len && (A[j]&0x1)==1) {
        		j += 2;
        	}
        	if(i<len && j<len){
                swap(A, i, j);   
                i += 2;
                j += 2;
            }
        }
        for(int a: A) {
        	System.out.print(a);
        }
		return A;
    }
	
	public void swap(int[] A, int i, int j) {
		int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {2,3,1,1,4,0,0,4,3,3};
		solution.sortArrayByParityII(A);
	}

}
