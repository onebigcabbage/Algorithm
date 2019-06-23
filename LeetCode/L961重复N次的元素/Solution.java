package L961重复N次的元素;

import java.util.HashSet;

public class Solution {
	
	public int repeatedNTimes(int[] A) {
		if(A.length <= 0)	return 0;
		HashSet<Integer> set = new HashSet<>(A.length/2);
		for (int value : A) {
			if(!set.add(value)) {
				return value;
			}
		}
		return 0;
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {2,1,3,5,2,2};
		int n = sol.repeatedNTimes(A);
		System.out.println(n);
	}

}
