package Tree;

import java.util.Stack;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode (int val) {
		this.val = val;
	}
}

public class Main {

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 5, 3 };
		int[] in = { 4, 2, 5, 1, 3 };
		TreeNode node = construct(pre, in);
		preOrder(node);
		System.out.println();
		midOrder(node);
		System.out.println();
		postOrder(node);

	}

	/**
	private static void preOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + " ");
			preOrder(node.left);
			preOrder(node.right);
		}	
	}
	*/

	private static void preOrder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null && !stack.empty()) {
			if (node != null) {
				System.out.print(node.val + " ");
				stack.push(node);
				node = node.left;
			} else {
				TreeNode temp = stack.pop();
				node = temp.right;
			}
		}
	}
	
	/**
	private static void midOrder(TreeNode node) {
		if (node != null) {
			midOrder(node.left);
			System.out.print(node.val + " ");
			midOrder(node.right);
		}	
	}
	*/

	private static void midOrder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null && !stack.empty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				TreeNode temp = stack.pop();
				System.out.print(node.val + " ");
				node = temp.right;
			}
		}
	}
	
	/**
	private static void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.val + " ");
		}	
	}
	*/

	private static void postOrder(TreeNode node) {
		TreeNode pre, cur = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while (!stack.empty()) {
			cur = stack.peek();
			if ((cur.left == null && cur.right == null) || (pre != cur.left && pre != cur.right)) {
				System.out.print(node.val + " ");
				stack.pop();
				pre = cur;
			} else {
				if (cur.left != null) {
					stack.push(cur.left);
				}
				if (cur.right != null) {
					stack.push(cur.right);
				}
			}
		}

	}


	private static TreeNode construct(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length) {
			return null;
		}
		return consMain(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private static TreeNode consMain(int[] pre, int ps, int pe, int[] in, int is, int ie) {
		if (ps > pe || is > ie) {
			return null;
		}
		int val = pre[ps];
		TreeNode node = new TreeNode(val);
		for (int i = is; i <= ie; i++) {
			if (in[i] == val) {
				node.left = consMain(pre, ps + 1, ps + i - is, in, is, i - 1);
				node.right = consMain(pre, ps + i - is + 1, pe, in, i + 1, ie);
			}
		}
		return node;
	}

}
