难度：简单

思路：

方法一:

1. 从头到尾遍历数组，找到当前数比前一个大，比后一个大就是所求。

方法二：

1. 设置头尾指针进行遍历，若最后两个指针相等，则是所求。

代码：

```java
// 方法一
public int peakIndexInMountainArray(int[] A) {
    if(A.length==0)	return 0;
    for(int i=1; i<A.length; i++) {
        if(A[i-1] < A[i] && A[i] > A[i+1]) {
            return i;
        }
    }
    return 0;
}
```

```java
// 方法二
public int peakIndexInMountainArray(int[] A) {
    if(A.length==0)	return 0;
    int i=0, j=A.length-1;
    while(i != j) {
        if (i < j && A[i] < A[i + 1]) {
            i++;
        }
        if (i < j && A[j] < A[j - 1]) {
            j--;
        }
    }
    if(i == j)	return i;
    return 0;
}
```



