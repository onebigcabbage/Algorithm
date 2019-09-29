##### [原题链接](https://leetcode-cn.com/problems/sqrtx/)

##### 难度 easy

##### 思路

##### 代码

```java
// 二分查找
class Solution {
    public int mySqrt(int x) {
        if (x <= 0)
        	return 0;
        long left = 1;
        // 一个数的平方根不会大于这个数字
        long right = x / 2;
        while (left < right) {
        	// 取右中位数,像4的话left会一直取1导致死循环
        	long middle = left + (right - left + 1) / 2;
        	if (middle * middle > x) {
        		right = middle - 1;
        	} else {
				left = middle;
			}
        }
    	return (int)left;
    }
}
```

