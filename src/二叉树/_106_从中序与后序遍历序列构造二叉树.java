package 二叉树;

import java.util.HashMap;

import 二叉树._105_从前序与中序遍历序列构造二叉树.TreeNode;

public class _106_从中序与后序遍历序列构造二叉树 {

	// 根据一棵树的中序遍历与后序遍历构造二叉树。
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
	private HashMap<Integer, Integer> dict;
	public  TreeNode MyBuildTree(int[] inorder, int[] postorder, int i_left, int i_right, int p_left, int p_right) {
		if (p_left > p_right) return null;
		int p_root = p_right;
		int i_root = dict.get(postorder[p_root]);
		TreeNode root = new TreeNode(postorder[p_root]);
		int left_count = i_root - i_left;
		root.left = MyBuildTree(inorder, postorder, i_left, i_root-1, p_left, p_left+left_count-1);
		root.right = MyBuildTree(inorder, postorder, i_root+1, i_right, p_left+left_count, p_right-1);
		return root;
	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	dict = new HashMap<Integer, Integer>();
    	int count = postorder.length;
    	for (int i = 0; i < count; i++) {
			dict.put(inorder[i], i);
		}
    	return MyBuildTree(inorder, postorder, 0, count-1, 0, count-1);
    }
}
