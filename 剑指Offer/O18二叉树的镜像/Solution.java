package O18二叉树的镜像;

import java.util.Stack;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int val) {
		this.val = val;
	}
}

public class Solution {
	
	// 递归
	public void Mirror(TreeNode root) {
        if (root == null)	return;
        if (root.left == null && root.right == null)	return;
        // 交换当前节点的左右子树
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        if (root.left != null) {
			Mirror(root.left);
		}
        if (root.right != null) {
        	Mirror(root.right);
        }
    }
	
	// 非递归
	public void Mirror2(TreeNode root) {
		if (root == null)	return;
        if (root.left == null && root.right == null)	return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	if (node.left != null || node.right != null) {
        		TreeNode tempNode = node.left;
                node.left = node.right;
                node.right = tempNode;
        	}
        	if (node.left != null) {
        		stack.push(node.left);
        	}
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        }
        
	}

}
