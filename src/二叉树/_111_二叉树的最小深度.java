package 二叉树;

public class _111_二叉树的最小深度 {

	// 给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
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
    public int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	if (root.left == null && root.right == null) return 1;
    	int height = Integer.MAX_VALUE;
    	if (root.left != null) {
			height = Math.min(minDepth(root.left), height);
		}
    	if (root.right != null) {
			height = Math.min(minDepth(root.right), height);
		}
    	return height + 1;
    }
}
