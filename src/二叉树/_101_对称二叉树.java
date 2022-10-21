package 二叉树;

import 二叉树._100_相同的树.TreeNode;

public class _101_对称二叉树 {
	public static void main(String[] args) {
		
	}
	// 给定一个二叉树，检查它是否是镜像对称的。
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
    public boolean isSymmetric(TreeNode root) {
    	return isSame(root, root);
    }
    public static boolean isSame(TreeNode left, TreeNode right) {
    	if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		} else {
			return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
		}
	}
}
