package com.xueqi;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//import com.sun.tools.javac.code.Attribute.Array;

public class Main {
	public static void main(String[] args) {
        System.out.println("Hello World wxq111");
        System.out.println("ni hao ");
        System.out.println("hahha");
        
        
        int[] numbers2 = new int[] {11,68,82,21,3,19,4};
        int[] numbers3 = port(numbers2);
        System.out.println("从小到大排序后的结果是2:");
        for (int i = 0; i < numbers3.length; i++) {
			System.out.println(numbers3[i] + " ");
		}
        
        char a = 'B';
        int b = a;
        
        System.out.println("转换之后的数据为："+b);
        
        Map<Object, Object> map = new HashMap<>();
        System.out.println("hash指为：" + map.hashCode());
        
//        Map<Object, Object map2 = new Hashtable<>();
    }
	
	/// 冒泡排序
	public static int[] port(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length-i-1; j++) {
				if (numbers[j] > numbers[j+1]) {
					int tmp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = tmp;
				}
			}
		}
		return numbers;
	}
}

