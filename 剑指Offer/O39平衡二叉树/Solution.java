package O39平衡二叉树;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
	
	/*
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		int diff = left - right;
		if (diff > 1 || diff < -1) {
			return false;
		}
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
	
	private int treeDepth(TreeNode node) {
		if (node == null)
			return 0;
		int left = treeDepth(node.left);
		int right = treeDepth(node.right);
		
		return left > right ? left + 1 : right + 1;
	}
	*/
	
	static class StopMsgException extends RuntimeException {
    }
	
	static boolean flag = true;
	
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		try {
			isBalanced(root);
		} catch (StopMsgException e) {
			return flag;
		}
		return flag;
    }

	private int isBalanced(TreeNode node) {
		if (node == null)
			return 0;
		int left = isBalanced(node.left);
		int right = isBalanced(node.right);
		int diff = left - right;
		if (diff > 1 || diff < -1) {
			flag = false;
			throw new StopMsgException();
		}
		return left > right ? left + 1 : right + 1;
	}
	
	

}
