package JZOffer;

import org.junit.Test;

public class JZ65_不用加减乘除做加法 {
	/*写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
示例:
输入: a = 1, b = 1
输出: 2
注意：不会溢出
*/
	//不会；  我感觉是要用位运算，但是不知道怎么做。
	//看了快一个小时，无法完全理解。直接背吧 :)
	class Solution {
		public int add(int a, int b) {
			while(b != 0) { // 当进位为 0 时跳出
				int c = (a & b) << 1;  // c = 进位
				a ^= b; // a = 非进位和
				b = c; // b = 进位
			}
			return a;
		}
	}
}
