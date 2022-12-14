package 二叉树;

import java.util.List;
import java.util.ArrayList;

public class _144_二叉树的前序遍历 {
	/*
	 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
	 * */

	public static void main(String[] args) {
		
	}
	
	public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		 this.val = val;
		 this.left = left;
		 this.right = right;
		 }
	}
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	preorder(root, res);
    	return res;
    }
    public static void preorder(TreeNode root, List<Integer> res) {
		if (root == null) return;
		res.add(root.val);
		preorder(root.left, res);
		preorder(root.right, res);
	}
}
