难度：中等

思路：
1. 最简单就是暴力法

   - 从首字母开始遍历，挨个添加直至出现重复的字符，跳出循环；
   - 从第二个字母重复之前的动作；
   - 循环，直至重复到最后一个字母。

2. 滑动窗口

   - 设置字符串 *s*，设置指针 $i$ ，$j$ ；

   - 从首位字符 $i=0$ 开始，依次将字符添加到 *s* 的末尾，直至碰到有重复的字符；

   - 从字符串 *s* 得到重复字符的所在位置设为 $j‘$ ，取 *s* 从 $j‘+1$ 到 $i$ 的子串作为当前字符串；

   - 继续遍历，直至遇到重复的字符。

代码：
```java
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
```

```java
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
```

