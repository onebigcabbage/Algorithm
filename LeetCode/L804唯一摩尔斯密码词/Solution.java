package L804唯一摩尔斯密码词;

import java.util.HashSet;

public class Solution {
	
	public int uniqueMorseRepresentations(String[] words) {
		if(words==null)	return 0;
		HashSet<String> set = new HashSet<>();
        String[] mosi = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String word : words) {
        	StringBuilder mosiword = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				mosiword.append(mosi[word.charAt(i)-'a']);
			}
			set.add(mosiword.toString());
		}
        System.out.println(set.size());
        return set.size();
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] words = {"gin", "zen", "gig", "msg"};
		sol.uniqueMorseRepresentations(words);
	}

}
