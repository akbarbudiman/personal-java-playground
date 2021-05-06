package src.main.java.binarytree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.main.java.binarytree.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {
	
	/*
	 * origin:
	 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 * 
	 * given: 
	 * root of a TreeNode
	 * 
	 * result:
	 * two dimension integer of the node.val : result, 
	 * where result start from BOTTOM level to TOP level,
	 * and elements of result[i] start from left to right
	 */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) return new ArrayList<>();
		
		List<List<Integer>> result = new ArrayList<>();
        
		Queue<TreeNode> nodesPerLevel = new LinkedList<TreeNode>();
		nodesPerLevel.offer(root);
		
		while (nodesPerLevel.isEmpty() == false) {
			ArrayList<Integer> thisLevelVal = new ArrayList<Integer>();
			int nodesPerLevelSize = nodesPerLevel.size();
			
			for (int i = 0 ; i < nodesPerLevelSize ; i = i + 1) {
				TreeNode node = nodesPerLevel.poll();
				thisLevelVal.add(node.val);
				
				if (node.left != null) {
					nodesPerLevel.offer(node.left);
				}
				
				if (node.right != null) {
					nodesPerLevel.offer(node.right);
				}
			}
			
			result.add(0, thisLevelVal);
		}
        
        return result;
    }
    
}
