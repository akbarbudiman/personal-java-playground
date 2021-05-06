package src.main.java.binarytree.dfs;

import src.main.java.binarytree.TreeNode;

public class SameTree {

	/*
	 * origin: 
	 * https://leetcode.com/problems/same-tree/
	 * 
	 * given: 
	 * two ThreeNode : p and q
	 * 
	 * result: 
	 * whether p and q are the same (structurally identical, and the nodes
	 * have the same value)
	 */

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p == null || q == null || p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
