package L461汉明距离;

public class Solution {
	
	public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while(res != 0) {
        	if((res&1)==1)	count++;
        	res >>= 1;
        }
//        Integer.bitCount(x^y);
        System.out.println(count);
		return count;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = 1, y = 4;
		solution.hammingDistance(x, y);
	}

}
