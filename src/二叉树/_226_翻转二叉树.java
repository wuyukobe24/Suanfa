package 二叉树;

import 二叉树._111_二叉树的最小深度.TreeNode;

public class _226_翻转二叉树 {

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
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return null;
    	myInvertTree(root);
    	return root;
    }
    public static void myInvertTree(TreeNode node) {
    	if (node == null) return;
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		myInvertTree(node.left);
		myInvertTree(node.right);
	}
}
