package O26二叉搜索树与双向链表;

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
	
	// 递归 从右往左建链表
	TreeNode pre = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return pRootOfTree;
		}
		Convert(pRootOfTree.right);
		if (pre == null) {
			pre = pRootOfTree;
		}else {
			pre.left = pRootOfTree;
			pRootOfTree.right = pre;
			pre = pRootOfTree;
		}
		Convert(pRootOfTree.left);
		return pre;
	}
	
	// 非递归 从前往后建链表
	/*
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<>();
		while (pRootOfTree != null || !stack.isEmpty()) {
			while (pRootOfTree != null) {
				stack.push(pRootOfTree);
				pRootOfTree = pRootOfTree.left;
			}
			pRootOfTree = stack.pop();
			if (pre == null) {
				pre = pRootOfTree;
			}else {
				pRootOfTree.left = pre;
				pre.right = pRootOfTree;
				pre = pRootOfTree;
			}
			pRootOfTree = pRootOfTree.right;
		}
		return pre;
	}
	*/
	
	// 非递归 从后往前建链表
	/*
    public TreeNode Convert(TreeNode pRootOfTree) {
    	if (pRootOfTree == null) {
			return null;
		}
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (pRootOfTree != null || !stack.isEmpty()) {
        	while (pRootOfTree != null) {
        		stack.push(pRootOfTree);
        		pRootOfTree = pRootOfTree.right;
        	}
        	pRootOfTree = stack.pop();
        	if (pre == null) {
				pre = pRootOfTree;
			}else {
				pRootOfTree.right = pre;
				pre.left = pRootOfTree;
				pre = pRootOfTree;
			}
        	pRootOfTree = pRootOfTree.left;
        }
        return pre;
    }
    */
	
}




