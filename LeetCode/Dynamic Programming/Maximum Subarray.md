##### [原题链接](https://leetcode-cn.com/problems/maximum-subarray/)

##### 难度 easy

##### 思路

##### 代码

```java
// DP
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}
```

