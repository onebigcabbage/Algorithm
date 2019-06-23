package L657机器人能否返回原点;

public class Solution {
	
	/*
	 * 法一：
	public boolean judgeCircle(String moves) {
        if(moves==null) return true;
        int row = 0, col = 0;
        for(int i=0; i<moves.length(); i++) {
        	switch (moves.charAt(i)) {
			case 'U':
				row += 1;
				break;
			case 'D':
				row -= 1;
				break;
			case 'L':
				col -= 1;
				break;
			case 'R':
				col += 1;
				break;
			}
        }
        if(row==0 && col==0) {
        	return true;
        }else {
        	return false;
        }
    }
    */
	
	
	// 法二
	public boolean judgeCircle(String moves) {
		int[] res = new int[20];
		for(int i=0; i<moves.length(); i++) {
			res[moves.charAt(i)-68]++;
		}
//		System.out.println('L'-68);
//		System.out.println('R'-68);
//		System.out.println('U'-68);
//		System.out.println('D'-68);
        return (res[8]==res[14] && res[17]==res[0]);
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		String moves = "UL";
		boolean res = sol.judgeCircle(moves);
		System.out.println(res);
	}

}
