package src.main.java.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

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
    	Queue<TreeNode[]> nodes = new LinkedList<TreeNode[]>();
    	nodes.offer(new TreeNode[] {root.left, root.right});
    	
    	while (nodes.isEmpty() == false) {
    		TreeNode[] pairNode = nodes.poll();
    		TreeNode left = pairNode[0];
    		TreeNode right = pairNode[1];
    		
    		if (left == null && right == null) 
    			continue;
    		
            else if (left == null || right == null) 
            	return false;
    		
            else if (left.val != right.val)
            	return false;
    		
    		nodes.offer(new TreeNode[] {left.left, right.right});
    		nodes.offer(new TreeNode[] {left.right, right.left});
    	}
    	
    	return true;
    }
    
}
