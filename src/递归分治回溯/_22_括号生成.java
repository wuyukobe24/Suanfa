package 递归分治回溯;
import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {

	/*
	 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		res.clear();
		dfs(n, 0, 0, "", res);
		return res;
	}

	public static void dfs(int n, int lc, int rc, String str, List<String> res) {
		if (n == lc && n == rc) res.add(str);
		if (lc < n) {
			System.out.println("lc= "+lc+ "("+" str="+str);
			dfs(n, lc + 1, rc, str + '(', res);
		}
		if (rc < n && rc < lc) {
			System.out.println("rc= "+rc+ ")"+" str="+str);
			dfs(n, lc, rc + 1, str + ')', res);
		}
	}
}
