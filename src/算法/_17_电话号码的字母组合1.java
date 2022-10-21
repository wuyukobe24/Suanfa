package 算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_电话号码的字母组合1 {

	/*
	 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
	 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
	 * 
	 * 输入：digits = "23"
	 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
	 * 
	 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
	 * */
	public static void main(String[] args) {
		String string = "23";
		List<String> res = letterCombinations(string);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	// 回溯
	public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

	
	// 普通方法
    public static List<String> letterCombinations2(String digits) {

    	List<String> res = new ArrayList<>();
    	if (digits.length() == 0) return res;
    	HashMap<Integer, String> dict = new HashMap<>();
    	dict.put(2, "abc");
    	dict.put(3, "def");
    	dict.put(4, "ghi");
    	dict.put(5, "jkl");
    	dict.put(6, "mno");
    	dict.put(7, "pqrs");
    	dict.put(8, "tuv");
    	dict.put(9, "wxyz");

        int[] arr = new int[digits.length()];
        for (int i = 0, len = arr.length; i < len; ++i) {
            arr[i] = digits.charAt(i) - '0';
        }
        String[] newArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
			newArray[i] = dict.get(arr[i]);
            System.out.println(newArray[i]);
		}
        
        if (newArray.length == 1) {
			return change(newArray[0]);
		}
        
        for (int i = 0; i < newArray.length-1; i++) {
			if (i == 0) {
				res = pinjie(change(newArray[0]),change(newArray[1]));
			} else {
				res = pinjie(res, change(newArray[i+1]));
			}
		}
    	return res;
    }
    
    public static List<String> change(String str) {
    	String[] arr = str.split("");
        List<String> res = Arrays.asList(arr);
        return res;
	}
    
    public static List<String> pinjie(List<String> arr1, List<String> arr2) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				res.add(arr1.get(i)+arr2.get(j));
			}
		}
        return res;
	}
}
