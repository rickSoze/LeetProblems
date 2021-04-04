package JZOffer;

import org.junit.Test;

public class JZ10_青蛙跳台阶问题 {
	/*一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
例 1：
输入：n = 2
输出：2
示例 2：
输入：n = 7
输出：21
示例 3：
输入：n = 0
输出：1
*/
//	class Solution {
	@Test
	public void myTest() {
		System.out.println(numWays(92));
	}
	//显然是动态规划，走到当前位置的路数等于前两个位置走2步+前一个位置走1步
	//注意结果可能会很大，要使用long进行记录。
	//但是当输入为92时，我的方法计算会出错？ 不知道为啥，可能是long也溢出了？
	//解决方法： 在每次计算时都先进行一个取模操作即可，也不用使用long了

	public int numWays(int n) {
		if (n == 0) {
			return 1;
		}
		long[] dp = new long[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		if (dp[n] > 1000000007) {
			return (int) (dp[n] % 1000000007);
		} else {
			return (int) dp[n];
		}
	}
//	}

	//修改之后
	//可以使用循环变量减小空间消耗
	class Solution {
		public int numWays(int n) {
			if (n == 0) {
				return 1;
			}
//			int[] dp = new int[n+1];
//			dp[0]=1;
//			dp[1]=1;
//			for (int i = 2; i < dp.length; i++) {
//				dp[i]= (dp[i-2]+dp[i-1])%1000000007;
//			}
//			return dp[n];

			int a = 1, b = 1, sum = 0;
			for (int i = 0; i < n; i++) {
				sum = (a + b) % 1000000007;
				a = b;
				b = sum;
			}
			return a;

		}
	}

}
