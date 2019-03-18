class Solution {

    // 方法一
    /*
    public String longestPalindrome(String s) {
        String res = "";
        int flag = 1;
        if(s.length() <= 1){
            return s;
        }
        for(int i=0; i<s.length()-1; i++){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    int m = i, n = j;
                    while(m<=n){
                        if(s.charAt(m) == s.charAt(n)){
                            m++;
                            n--;
                        }else{
                            flag = 0;
                            break;
                        }
                    }
                    if(flag == 1){
                        if((j-i+1)>res.length()){
                            res = s.substring(i, j+1);
                        }
                    }
                    flag = 1;
                }
            }
        }
        if(res.equals("")){
            return s.substring(s.length()-1, s.length());
        }else{
            return res;
        }
    }
    */

    public static void main(String[] args) {
        Solution sol = new Solution();
        // String s = "abccbdad";
        String s = "a";
        System.out.println(sol.longestPalindrome(s));
        // System.out.println(s.substring(0, 1));
    }
}