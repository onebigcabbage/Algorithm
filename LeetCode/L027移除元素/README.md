难度：简单

思路：

1. 可以设置两个下标 *i* ，*j*。
2. 遍历数组，如果 *nums[i]* 和要移除的元素不同，则 *nums[i] = nums[j]* ；否则，跳过。

代码：

```java
public int removeElement(int[] nums, int val) {
    int i = 0;
    for(int j=0; j<nums.length; j++) {
        if (nums[j] != val) {
            nums[i] = nums[j];
            i++;
        }
    }
    return i;
}
```



