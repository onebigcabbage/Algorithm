package L509斐波那契数;

public class Solution {
	
	/* 递归
	public int fib(int N) {
        if(N == 0)	return 0;
        else if(N == 1)	return 1;
        else {
			return fib(N-1) + fib(N-2);
		}
    }
    */
	
	public int fib(int N) {
        if(N == 0)	return 0;
        if(N == 1)	return 1;
        int f0 = 0, f1 = 1;
        for(int i=2; i<=N; i++) {
        	int temp = f0 + f1;
        	f0 = f1;
        	f1 = temp;
        }
        return f1;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int N = 5;
		int n = solution.fib(N);
		System.out.println(n);
		
	}

}
