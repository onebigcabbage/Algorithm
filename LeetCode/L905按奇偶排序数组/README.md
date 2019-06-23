难度：简单

思路：

1. 利用快排,设置头尾两个指针；
2. 尾指针指向元素若为偶，头指针指向元素若为奇，则互换。

代码：

```java
public int[] sortArrayByParity(int[] A) {
    if(A.length==0) return A;
    int i = 0, j = A.length-1;
    while(i < j) {
        while(i<j && A[i]%2==0) {
            i++;
        }
        while(i<j && A[j]%2==1) {
            j--;
        }
        int value = A[i];
        A[i] = A[j];
        A[j] = value;
        i++;
        j--;
    }
    return A;
}
```



