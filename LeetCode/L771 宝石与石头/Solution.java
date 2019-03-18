class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J.length()<=0 || S.length()<=0)  return 0;
        int count = 0;
        for(int i=0; i<S.length(); i++){
            if(J.contains(Character.toString(S.charAt(i)))){
                count++;
            }
        }
        return count;
    }
}