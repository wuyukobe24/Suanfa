package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 二叉树._144_二叉树的前序遍历.TreeNode;

public class _104_二叉树的最大深度 {

	/*
	 * 给定一个二叉树，找出其最大深度。
	 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	 * 说明: 叶子节点是指没有子节点的节点。
	 * */
    public int maxDepth(TreeNode root) {
    	if (root == null) return 0;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
		Integer height = 0;
    	while (!q.isEmpty()) {
    		Integer count = q.size();
    		while (count > 0) {
    			TreeNode node = q.poll();
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				count--;
			}
			height++;
		}
    	return height;
    }
    
    
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		Integer height = 0;
		while (!q.isEmpty()) {
			height++;
			List<Integer> tmp = new ArrayList<>();
			Integer count = q.size();
			while (count > 0) {
				TreeNode node = q.poll();
				if (height % 2 == 1) {
					tmp.add(node.val);
				} else {
					tmp.add(0, node.val);
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				count--;
			}
			res.add(tmp);
		}
		return res;
	}
	
	 public int maxDepth2(TreeNode root) {
		 if (root == null) {
			return 0;
		}
		 int leftHeight = maxDepth(root.left);
		 int rightHeight = maxDepth(root.right);
		 return Math.max(leftHeight, rightHeight) + 1;
	 }
}
