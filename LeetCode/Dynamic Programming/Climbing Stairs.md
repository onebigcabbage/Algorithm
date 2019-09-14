##### [原题链接](https://leetcode-cn.com/problems/climbing-stairs/)

##### 难度 easy

##### 思路

##### 代码

```java
class Solution {
    public int climbStairs(int n) {
        if (n < 3)
            return n;
        int c1 = 1, c2 = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = c1 + c2;
            c1 = c2;
            c2 = c;
        }
        return c2;
    }
}
```

