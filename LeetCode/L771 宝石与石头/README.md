难度：简单
题目链接：[LeetCode](https://leetcode-cn.com/problems/jewels-and-stones/)

思路：

1. 判断 *S* 中的字母是否在 *J* 中即可；
2. *String.charAt(int i)* 函数是得到字符串中的第 *i* 个字母，返回的是 *char* 类型；
3. *Character.toString()* 函数是将 *char* 类型的字母转为 *String* 类型。

代码：

```java
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
```





