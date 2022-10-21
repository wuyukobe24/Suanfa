package 数组;

public class _58_左旋转字符串 {

	public static void main(String[] args) {
		String string = "abcdefg";
		System.out.println(reverseLeftWords(string, 2));
	}
	
	/*
	 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
	 * 请定义一个函数实现字符串左旋转操作的功能。
	 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
	 * */
	
    public static String reverseLeftWords(String s, int n) {
    	if (n >= s.length()) return s;
    	String left = "", right = "";
    	char[] nums = s.toCharArray();
    	for (int i = 0; i < nums.length; i++) {
			if (i<n) {
				left += nums[i];
			} else {
				right += nums[i];
			}
		}
    	return right + left;
    }
}
