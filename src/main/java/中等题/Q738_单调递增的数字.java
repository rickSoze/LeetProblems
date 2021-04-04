package 中等题;


import org.junit.Test;

import java.util.Arrays;

public class Q738_单调递增的数字 {
	/*给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:
输入: N = 10
输出: 9

示例 2:
输入: N = 1234
输出: 1234

示例 3:
输入: N = 332
输出: 299
*/
	@Test
	public void myTest(){
		System.out.println(monotoneIncreasingDigits(376));
//		char[] c = {'1', '2','3'};
//		System.out.println(c[2]);
//		System.out.println((c[2]-'2'+'1'));
	}

//	class Solution {
		/**
		 * 思路：
		 *  从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
		 *  则把其左边一位数字减1，并将该位及其右边的所有位改成9
		 */
		public  int monotoneIncreasingDigits(int n) {
			String s = String.valueOf(n);
			int length = s.length();
			char[] chars = s.toCharArray();
			int flag = length;
			for (int i = length - 1; i >= 1; i--) {
				if (chars[i] < chars[i - 1]) {
					flag = i;
					chars[i - 1]--;
				}
			}

			for (int i = flag; i < length; i++) {
				chars[i] = '9';
			}
			return Integer.parseInt(new String(chars));

		}

//	}




	//思路正确，实现很丑陋！
	class Solution1 {
		public int monotoneIncreasingDigits(int N) {
		if (N%10==0){
		    return N-1;
		}
			char[] num = String.valueOf(N).toCharArray();
			StringBuilder sb = new StringBuilder();

			for (int j = num.length-1; j >0 ; j--) {
				if (num[j]=='0'){
					num[j]='9';
					num[j-1]=(char)(num[j-1]-'2'+'1');
				}
			}

			for (int i = num.length-1; i > 0 ; i--) {
				if (num[i]<num[i-1]){
				    if (i==num.length-1){
						num[i]='9';
						for (int j = i-1; j >=0 ; j--) {
							if (num[j]!='0'){
							    num[j]=(char)(num[j]-'2'+'1');
							    break;
							}else {
								num[j]='9';
							}
						}
				    }else {
				    	num[i]=num[i+1];
						for (int j = i-1; j >=0 ; j--) {
							if (num[j]!='0'){
								num[j]=(char)(num[j]-'2'+'1');
								break;
							}else {
								num[j]='9';
							}
						}
					}
				}
				sb.append(num[i]);
			}
			sb.append(num[0]);

			return Integer.parseInt(sb.reverse().toString());
		}
	}
}
