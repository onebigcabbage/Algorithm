难度：简单

思路：

1. *toCharArray()* 函数将字符串返回为 *char* 类型的数组；

代码：

```java
public String toLowerCase(String str) {
    char[] value = str.toCharArray();
    for(int i=0; i<value.length; i++){
        if(value[i] >='A' && value[i]<='Z'){
            // ways 1
            value[i] += 32;
            // ways 2
//            	value[i] = (char) (value[i] + 'a' - 'A');
        }
    }
    return String.valueOf(value);
}
```



