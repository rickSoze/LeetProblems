package JZOffer;

import org.junit.Test;

public class JZ15_二进制中1的个数 {
	/*请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
	例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
示例 1：

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
。*/
	public class Solution {
		/*
		* 最优解：
		* n&(n−1) 解析： 二进制数字 n 最右边的一个 1 变成 0 ，其余不变。
		* 利用这个特性，每次运算判断这个数是否变为0了，没变则说明减少了一个1
		* */
			public int hammingWeight(int n) {
				int res = 0;
				while(n != 0) {
					res++;
					n &= n - 1;
				}
				return res;
			}


		// 每次判断位数是否是1，然后右移整个数再接着判断
		public int hammingWeight1(int n) {
			int cnt=0;
 			while (n!=0){
				if ((n&1)==1){
					cnt++;
				}
				n>>>=1;
			}
			return cnt;
		}
		//简单优化这个方法
		public int hammingWeight2(int n) {
				int res = 0;
				while(n != 0) {
					res += n & 1;
					n >>>= 1;
				}
				return res;
			}
	}

}
