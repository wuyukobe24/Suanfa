package 二叉树;

import java.util.List;
import java.util.ArrayList;

public class _94_二叉树的中序遍历 {

	// 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
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
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	inorder(root, res);
    	return res;
    }
    public static void inorder(TreeNode node, List<Integer> res) {
		if (node == null) return;
		inorder(node.left, res);
		res.add(node.val);
		inorder(node.right, res);
	}
}
