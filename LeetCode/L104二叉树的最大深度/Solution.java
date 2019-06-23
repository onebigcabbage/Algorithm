package L104二叉树的最大深度;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}

public class Solution {
	
	public int maxDepth(TreeNode root) {
		return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }

}
