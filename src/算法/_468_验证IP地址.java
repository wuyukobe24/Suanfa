package 算法;

public class _468_验证IP地址 {
	public static void main(String[] args) {
		String str = "172.1.254.0";
		String str1 = "2001:db8:85a3:0:0:8A2E:0370:7334";
		System.out.println(validIPAddress(str1));
		
		String str2 = "172.1.254.0";
		System.out.println(defangIPaddr(str2));
	}
	// https://leetcode.cn/problems/validate-ip-address/solution/by-jiang-hui-4-qtsa/
    public static String validIPAddress(String queryIP) {
    	if (queryIP.length() == 0) return "Neither";
    	if (queryIP.indexOf(".") > 0 && isIpv4(queryIP)) return "IPv4";
    	if (queryIP.indexOf(":") > 0 && isIpv6(queryIP)) return "IPv6";
    	return "Neither";
    }
    
    public static boolean isIpv4(String queryIP) {
    	//加-1是防止出现空字符串无法计数 比如192.168.1.1. 后边多了一个点，不加-1会被忽略后边的空串
    	String[] ipsStr = queryIP.split("\\.",-1);
    	if (ipsStr.length != 4) return false;
		for (String str : ipsStr) {
			//每个长度不在 1-3之间
			if (str.length() <= 0 || str.length() > 3) return false;
			//有前导0 并且长度不为1
			if (str.charAt(0) == '0' && str.length() > 1) return false;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				//不是数字
				if (!Character.isDigit(c)) {
					return false;
				}
			}
			//数字不超过255
			int tmp = Integer.valueOf(str);
			if (tmp < 0 || tmp > 255) return false;
		}
    	return true;
    }
    public static boolean isIpv6(String queryIP) {
    	String[] ipsStr = queryIP.split(":",-1);
    	if (ipsStr.length != 8) return false;
		for (String str : ipsStr) {
			//每个串 长度不在1-4之间
			if (str.length() <= 0 || str.length() > 4) return false;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				//不是数字并且字母不在 a-f之间
				if (!Character.isDigit(c) && !(Character.toLowerCase(c) >= 'a') || !(Character.toLowerCase(c) <= 'f')) {
					return false;
				}
			}
		}
    	return true;
    }
    
    // 1108. IP 地址无效化
    // 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
    // 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
    public static String defangIPaddr(String address) {
    	return address.replace(".", "[.]");
    }
}
