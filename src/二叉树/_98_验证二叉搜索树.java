package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _98_验证二叉搜索树 {

	/*
	 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

链接：https://leetcode.cn/problems/validate-binary-search-tree
	 * */
	
	class TreeNode {
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
	
	// 第一种：中序遍历，然后判断是否是升序
    public boolean isValidBST(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	port(root, list);
    	for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i-1)) {
				return false;
			}
		}
    	return true;
    }
    
    public static List<Integer> port(TreeNode root, List<Integer> list) {
		if (root == null) return null;
		port(root.left, list);
		list.add(root.val);
		port(root.right, list);
    	return null;
	}
    
    // 第二种:中序遍历中直接判断当前节点是否大于上个节点
    long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
    	if (root == null) return true;
    	if (!isValidBST(root.left)) {
			return false;
		}
    	if (root.val <= pre) {
			return false;
		}
    	pre = root.val;
    	return isValidBST(root.right);
    }
    
    
}
