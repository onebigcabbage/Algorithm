package O28数组中出现次数超过一半的数字;

public class Solution {
	
    public int MoreThanHalfNum_Solution(int [] array) {
    	if (array.length <= 0) {
			return 0;
		}
        int index = 1, res = array[0];
        for (int i = 0; i < array.length; i++) {
        	if (index == 0) {
				res = array[i];
				index = 1;
			}
			if (res == array[i]) {
				index++;
			}else {
				index--;
			}
		}
        int count = 0;
        for (int i = 0; i < array.length; i++) {
			if (array[i] == res) {
				count++;
			}
		}
        if (count <= array.length / 2) {
			return 0;
		}
    	return res;
    }
    
}
