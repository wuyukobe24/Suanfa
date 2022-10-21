package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 二叉树._144_二叉树的前序遍历.TreeNode;

public class _102_二叉树的层序遍历 {

	// 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if (root == null) return new ArrayList<>();
    	List<List<Integer>> res = new ArrayList<>();
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while (!q.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			Integer count = q.size();
			while (count > 0) {
				TreeNode node = q.poll();
				tmp.add(node.val);
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
    
    
    
    // 剑指 Offer 32 - I. 从上到下打印二叉树
    // 返回结果  [3,9,20,15,7]
    public int[] levelOrder1(TreeNode root) {
    	if (root == null) return new int[]{};
    	List<Integer> list = new ArrayList<>();
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while (!q.isEmpty()) {
			TreeNode node = q.poll();
			list.add(node.val);
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
    	int[] res = new int[list.size()];
    	for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
    	return res;
    }
}
