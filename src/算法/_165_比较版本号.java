package 算法;

public class _165_比较版本号 {
	/*
	 * 思路：分割成数组，比较每个数据同索引位置的大小，若一样，则比较长数组剩余元素是否大于1，若大于1则大于。若均等于0则相等。
	 * */
	public static void main(String[] args) {
		String str1 = "1.2.0";
		String str2 = "1.20";
		System.out.println(compareVersion(str1, str2));
	}
    public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0, j = 0;
		while (i < v1.length && j < v2.length) {
			int a = Integer.valueOf(v1[i]);
			int b = Integer.valueOf(v2[j]);
			if (a > b) {
				return 1;
			} else if (a < b) {
				return -1;
			}
			i++;
			j++;
		}
		if (v1.length > v2.length) {
			for (int k1 = i; k1 < v1.length; k1++) {
				if (Integer.valueOf(v1[k1]) > 0) {
					return 1;
				}
			}
			return 0;
		} else if (v1.length < v2.length) {
			for (int k2 = j; k2 < v2.length; k2++) {
				if (Integer.valueOf(v2[k2]) > 0) {
					return -1;
				}
			}
			return 0;
		}
		return 0;
    }
}
