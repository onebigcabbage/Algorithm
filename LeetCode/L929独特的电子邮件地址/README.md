难度：简单

思路：

1. 得到字母 *@* 的下标，将 *@* 之前的字符串进行处理；
2. 将处理好的字符串放到 *Set* 中，这样只会存入不一样的字符串。
3. *indexOf()* 函数返回字符串中子串第一次出现的位置；
4. *substring(int i, int j)* 函数返回下标 *i* 到下标 *j-1* 的子串。

代码：

```java
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
    return set.size();
}
```



