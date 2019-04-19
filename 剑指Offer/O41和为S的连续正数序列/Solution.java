package 和为S的连续正数序列;

import java.util.ArrayList;

public class Solution {
	
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
		int left = 1, right = 2;
		while (left < right) {
			int cursum = (left + right) * (right - left + 1) / 2;
			if (cursum == sum) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = left; i <= right; i++) {
					list.add(i);
				}
				allList.add(list);
				left++;
			} else if (cursum < sum) {
				right++;
			} else {
				left++;
			}
		}
		return allList;
    }
	

}
