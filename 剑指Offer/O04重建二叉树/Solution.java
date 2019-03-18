package O04重建二叉树;

public class Solution {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		// 边界条件
		if (pre == null || in == null || pre.length != in.length) {
			return null;
		}
		return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}
	
	public TreeNode construct(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
		if (preS > preE || inS > inE)
			return null;
		// 前序遍历的第一个是根节点,创建根节点
		TreeNode node = new TreeNode(pre[preS]);
		for (int i = inS; i <= inE; i++) {
			// 在中序遍历中寻找根节点
			if (in[i] == pre[preS]) {
				// 递归调用，根据当前根节点构建左子树
				node.left = construct(pre, preS + 1, preS + i - inS, in, inS, i - 1);
				// 递归调用，根据当前根节点构建右子树
				node.right = construct(pre, preS + i - inS + 1, preE, in, i + 1, inE);
			}
		}
		return node;
	}

	private void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			System.out.println(root.val + " ");
			printTree(root.right);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode node = solution.reConstructBinaryTree(pre, in);
		solution.printTree(node);
	}


}
