package O38二叉树的深度;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
	
	/* 递归
    public int TreeDepth(TreeNode root) {
    	if (root == null)
    		return 0;
        int nleft = TreeDepth(root.left);
        int nright = TreeDepth(root.right);
        return nleft > nright ? nleft + 1 : nright + 1;
    }
    */
    
    public int TreeDepth(TreeNode root) {
    	if (root == null)
    		return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue != null) {
        	depth++;
        	for (int i = 0; i < queue.size(); i++) {
        		TreeNode node = queue.poll();
        		if (node.left != null) {
        			queue.add(node.left);
        		}
        		if (node.right != null) {
        			queue.add(node.right);
        		}
			}
        }
    	return depth;
    }
    
}
