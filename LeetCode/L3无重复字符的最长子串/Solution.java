class Solution {
    /* 方法一
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            String set = "";
            for(int j=i; j<s.length(); j++){
                String temp = Character.toString(s.charAt(j));
                if(!set.contains(temp)){
                    set += temp;
                }else{
                    break;
                }
                count = Math.max(count, set.length());
            }
        }
        return count;
    }
    */

    // 方法二
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        String temp = "";
        int j = 0;
        for(int i=0; i<s.length(); i++){
            if(temp.contains(Character.toString(s.charAt(i)))){
                temp = temp.substring(temp.indexOf(s.charAt(i))+1, temp.length());
            }
            temp += s.charAt(i);
            count = Math.max(count, temp.length());
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = sol.lengthOfLongestSubstring("alqebriavxoo");
        System.out.println(n);
    }
}