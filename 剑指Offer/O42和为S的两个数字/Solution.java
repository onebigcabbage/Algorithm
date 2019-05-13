package O42和为S的两个数字;

import java.util.ArrayList;

public class Solution {
	
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array.length < 2 || array == null)
        	return list;
        int start = 0, end = array.length - 1;
        while (start < end) {
        	if (array[start] + array[end] == sum) {
        		list.add(array[start]);
        		list.add(array[end]);
        		return list;
        	}else if (array[start] + array[end] > sum){
				end--;
			} else {
				start++;
			}
        }
        return list;
    }

}
