

```java
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int row = in.nextInt();
    int col = in.nextInt();
    int[][] matrix = new int[row][col];

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            matrix[i][j] = Integer.valueOf(in.nextInt());
        }
    }
    /**
     * 动态规划
     * 
     * 时间复杂度为 O(row * col)
     * 需要额外的空间 O(row * col)
     * 
     */
    int[][] dp = new int[row][col];
    // 辅助数组第一位直接记录下来
    dp[0][0] = matrix[0][0];
    // 第一列的每个元素都是上一个元素加上数组中该位置的值
    for (int i = 1; i < row; i++) {
        dp[i][0] = dp[i - 1][0] + matrix[i][0];
    }
    // // 第一行的每个元素都是前一个元素加上数组中该位置的值
    for (int i = 1; i < col; i++) {
        dp[0][i] = dp[0][i - 1] + matrix[0][i];
    }
    // 从array[1][1] 开始计算
    for (int i = 1; i < row; i++) {
        for (int j = 1; j < col; j++) {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
        }
    }
    System.out.println(dp[row - 1][col - 1]);
}
```

