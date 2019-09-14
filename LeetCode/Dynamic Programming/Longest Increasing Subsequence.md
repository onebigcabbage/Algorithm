##### [原题链接](https://leetcode-cn.com/problems/longest-increasing-subsequence)

##### 难度 medium

##### [解析链接](https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/) 

##### 代码

```java
// 贪心 + 二分
public int lengthOfLIS(int[] array) {
    int len = array.length;
    if (len <= 1)
        return len;

    int maxLen = 0;
    int[] aux = new int[len];
    aux[0] = array[0];
    int flag = 0;

    for (int i = 1; i < len; i++) {
        if (array[i] > aux[flag]) {
            aux[++flag] = array[i];
        } else {
            int middle = binaryasearch(aux, array[i], 0, flag);
            aux[middle] = array[i];
        }
    }
    for (int i = 0; i < len; i++) {
        if (aux[i] != 0) 
            maxLen++;
    }
    System.out.println(maxLen);
    return maxLen;
}
public int binaryasearch(int[] aux, int target, int left, int right) {
    while (left < right) {
        int middle = (left + right) >>> 1;
        if (aux[middle] > target) {
            left = middle + 1;
        } else {
            right = middle;
        }
    }
    return left;
}


// 动态规划
public int lengthOfLIS(int[] array) {
    if (array.length == 0)
        return 0;

    int maxLen = 0;
    int[] dp = new int[array.length];
    Arrays.fill(dp, 1);

    // 全部遍历
    for (int i = 1; i < array.length; i++) {
        // 从首位到当前的前一位遍历判断
        for (int j = 0; j < i; j++) {
            if (array[j] < array[i])
                dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }

    for (int i = 0; i < dp.length; i++) {
        maxLen = Math.max(maxLen, dp[i]);
    }
    System.out.println(maxLen);
    return maxLen;
}
```

