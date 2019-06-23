难度：简单

思路：

1. 根据题目描述，可知只有所求的那个数是重复的，只要碰到重复的数字就是要找的数字。

代码：

```java
public int repeatedNTimes(int[] A) {
    if(A.length <= 0)	return 0;
    HashSet<Integer> set = new HashSet<>(A.length/2);
    for (int value : A) {
        if(!set.add(value)) {
            return value;
        }
    }
    return 0;
}
```



