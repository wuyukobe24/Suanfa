package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 二叉树._144_二叉树的前序遍历.TreeNode;

public class _107_二叉树的层序遍历2 {

	// 给定一个二叉树，返回其节点值自底向上的层序遍历。 
	//（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (root == null) return res;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while (!q.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			Integer count = q.size();
			while (count > 0) {
				TreeNode node = q.poll();
				list.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				count--;
			}
			res.add(0, list);
		}
    	return res;
    }
}
