package src.main.java.binarytree.dfs;

import src.main.java.binarytree.TreeNode;

public class SymmetricTree {

	/*
	 * origin:
	 * https://leetcode.com/problems/symmetric-tree/
	 * 
	 * given: 
	 * root of a TreeNode
	 * 
	 * result:
	 * whether that TreeNode is symmetric around its center (a mirror of itself)
	 */
	
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        return left.val == right.val
                && isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);
    }
	
}
