难度：简单

思路：

代码：

```java
public int[][] flipAndInvertImage(int[][] A) {
    if (A == null)
        return null;
    for (int[] value : A) {
        for (int j = 0; j <= value.length / 2; j++) {
            int temp = value[j];
            value[j] = value[value.length - 1 - j];
            value[value.length - 1 - j] = temp;
        }
        for (int l = 0; l < value.length; l++) {
            value[l] ^= 1;
        }
    }
    return A;
}
```



