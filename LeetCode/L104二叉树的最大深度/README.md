难度：简单

代码：

```java
public int maxDepth(TreeNode root) {
    return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
}
```



