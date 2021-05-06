package src.main.java.binarytree.dfs;

import java.util.ArrayList;
import java.util.List;

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
	
    private List<List<Integer>> result;
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        this.result = new ArrayList<>();
        levelOrderBottomHelper(root, 0);
        return this.result;
    }
    
    public void levelOrderBottomHelper(TreeNode node, int height) {
        if (node == null) return;
        
        int currentHeight = this.result.size();
        if (height >= currentHeight) {
            this.result.add(0, new ArrayList<Integer>());
            currentHeight = currentHeight + 1;
        }
        
        this.result.get(currentHeight - 1 - height).add(node.val);
        levelOrderBottomHelper(node.left, height + 1);
        levelOrderBottomHelper(node.right, height + 1);
    }
}
