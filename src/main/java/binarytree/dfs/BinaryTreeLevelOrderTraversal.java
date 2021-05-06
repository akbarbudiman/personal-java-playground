package src.main.java.binarytree.dfs;

import java.util.ArrayList;
import java.util.List;

import src.main.java.binarytree.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	
	/*
	 * origin:
	 * https://leetcode.com/problems/binary-tree-level-order-traversal/
	 * 
	 * given: 
	 * root of a TreeNode
	 * 
	 * result:
	 * two dimension integer of the node.val : result, 
	 * where result start from top level to bottom level,
	 * and elements of result[i] start from left to right
	 */
	
    private List<List<Integer>> result;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        levelOrderHelper(root, 0);
        return this.result;
    }
    
    public void levelOrderHelper(TreeNode node, int height) {
        if (node == null) return;
        
        int currentHeight = this.result.size();
        if (height >= currentHeight) {
            this.result.add(new ArrayList<Integer>());
        }
        
        this.result.get(height).add(node.val);
        levelOrderHelper(node.left, height + 1);
        levelOrderHelper(node.right, height + 1);
    }
}
