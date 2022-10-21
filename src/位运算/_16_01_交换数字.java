package 位运算;

public class _16_01_交换数字 {

	/*
	 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
	 * 输入: numbers = [1,2]
	 * 输出: [2,1]
	 * */
    public int[] swapNumbers(int[] numbers) {
    	numbers[0] = numbers[0] + numbers[1];
    	numbers[1] = numbers[0] - numbers[1];
    	numbers[0] = numbers[0] - numbers[1];
    	return numbers;
    }
    
    // 使用异或 ^
    public int[] swapNumbers2(int[] numbers) {
    	numbers[0] ^= numbers[1];// numbers[0]此时存放两数异或的结果
    	numbers[1] ^= numbers[0];// numbers[1]此时1位置数异或两次为0,故只剩0位置数
    	numbers[0] ^= numbers[1];// numbers[0]此时0位置数异或两次为0,故只剩1位置数
        return numbers;
    }

}
