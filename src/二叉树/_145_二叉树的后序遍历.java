package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _145_二叉树的后序遍历 {

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
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	postorder(root, res);
    	return res;
    }
    public static void postorder(TreeNode node, List<Integer> res) {
		if (node == null) return;
		postorder(node.left, res);
		postorder(node.right, res);
		res.add(node.val);
	}
    
}
