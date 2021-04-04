package JZOffer;

import org.junit.Test;

import java.util.HashSet;

public class JZ17_打印从1到最大的n位数 {
	/*输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

*/

	class Solution {
		public int[] printNumbers(int n) {
			int max = (int)Math.pow(10,n);
			int[] ints = new int[max - 1];
			for (int i = 1; i < max; i++) {
				ints[i-1]=i;
			}

			return ints;
		}
	}
}
