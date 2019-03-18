package O17树的子结构;

public class Solution {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}
	}
	
	
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean res = false;
        if (root1 != null && root2 != null) {
			if (root2.val == root1.val) {
				res = Tree1haveTree2(root1, root2);
			}
			if (!res) {
				res = Tree1haveTree2(root1.left, root2);
			}
			if (!res) {
				res = Tree1haveTree2(root1.right, root2);
			}
		}
        return res;
    }

	public boolean Tree1haveTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root2.val != root1.val) {
			return false;
		}
		return Tree1haveTree2(root1.left, root2.left) && Tree1haveTree2(root1.right, root2.right);
	}


}
