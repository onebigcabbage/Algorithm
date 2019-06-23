难度：简单

思路：

1. 设置两个指针，*i* 从 *0* 开始，*j* 从 *1* 开始，每次增加 *2* ，保证 *i* 只检测偶数位，*j* 检测奇数位。
2. 循环整个数组，遇到不满足条件的交换 *A[i]* 和 *A[i]* 的值即可。
3. 注意给定的三个条件。

代码：

```java
public int[] sortArrayByParityII(int[] A) {
        if(A.length==0) return A;
        int i = 0, j = 1, len = A.length;
        while(i < len && j < len) {
        	while(i<len && (A[i]&0x1)==0) {
        		i += 2;
        	}
        	while(j<len && (A[j]&0x1)==1) {
        		j += 2;
        	}
        	if(i<len && j<len){
                swap(A, i, j);   
                i += 2;
                j += 2;
            }
        }
		return A;
    }
	
	public void swap(int[] A, int i, int j) {
		int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
}
```



