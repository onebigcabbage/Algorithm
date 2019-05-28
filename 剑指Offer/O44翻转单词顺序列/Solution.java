package 翻转单词顺序列;

public class Solution {
    
    public void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public String ReverseSentence(String str) {
        if (str == null || str.length() < 1)
            return str;
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(arr, i, arr.length - 1);
        return new String(arr);
    }
}