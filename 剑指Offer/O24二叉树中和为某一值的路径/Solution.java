package O24二叉树中和为某一值的路径;

import java.util.ArrayList;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class Solution {
	
	ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if (root == null)	return listAll;
        list.add(root.val);
        target -= root.val;
        // 按照数组长度放入listAll中
        if ((target == 0) && root.left == null && root.right == null) {
        	int listCount = 0;
        	while (listCount < listAll.size() && list.size() < listAll.get(listCount).size()) {
        		listCount++;
        	}
			listAll.add(listCount, new ArrayList<Integer>(list));
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size()-1);
        return listAll;
    }

}
