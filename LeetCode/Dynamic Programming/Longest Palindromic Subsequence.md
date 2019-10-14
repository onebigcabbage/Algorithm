##### [原题链接](https://leetcode-cn.com/problems/longest-palindromic-subsequence/)

##### 难度 medium

##### 思路

注意：子序列可以是不连续的，可以跳过某些单词，和子串不同，子串是必须连续的

##### 代码

```java
public static int longestPalindromeSubseq(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    int n = s.length();
    int[][] dp = new int[n][n];

    for (int i = n - 1; i >= 0; i--) {
        dp[i][i] = 1;
        for (int j = i + 1; j < n; j++) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = dp[i + 1][j - 1] + 2;
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[0][n - 1];
}
```

