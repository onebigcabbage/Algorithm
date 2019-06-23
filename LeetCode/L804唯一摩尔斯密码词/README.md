难度：简单

思路：

1. *StringBuilder* 是可变的，线性不安全的字符串，比 *String* 的操作时间要快；
2. *String.charAt(int i)* 函数是取字符串的第 *i* 个字符，返回类型是 *char* 。

代码：

```java
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
    return set.size();
}
```



