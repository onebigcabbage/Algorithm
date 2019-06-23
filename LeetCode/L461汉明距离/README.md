难度：简单

思路：

1. 判断两个二进制不同的个数，首先可以想到的就是异或操作，即不同为 *1* 。
2. 异或计算后得到十进制的结果，该结果的二进制中 *1* 的个数即所求。
3. 将结果和 *1* 做与运算可以判断最后一位是否为 *1* ，然后右移，直至为 *0* 。

代码：

```java
public int hammingDistance(int x, int y) {
    int res = x ^ y;
    int count = 0;
    while(res != 0) {
        if((res&1)==1)	count++;
        res >>= 1;
    }
    return count;
}
```



