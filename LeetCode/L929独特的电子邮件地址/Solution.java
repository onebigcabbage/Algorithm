import java.util.HashSet;

class Solution {

    public int numUniqueEmails(String[] emails) {
        if(emails == null)  return 0;
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            if(!email.equals("")){
                String str = "";
                int i = email.indexOf("@");
                if(email.substring(0, i).contains("+")){
                    str = email.substring(0, email.indexOf("+")).replace(".", "") + email.substring(i, email.length());
                }else{
                    str = email.substring(0, i).replace(".", "") + email.substring(i, email.length());
                }
                set.add(str);
            }
        }
        // System.out.println(set);
        // System.out.println(set.size());
        return set.size();
    }
    

    public static void main(String[] args) {
        Solution sol = new Solution();
        // String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", ""};
        sol.numUniqueEmails(emails);
    }
}