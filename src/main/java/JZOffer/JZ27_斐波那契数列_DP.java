package JZOffer;

import org.junit.Test;

public class JZ27_斐波那契数列_DP {
	/*题目描述  1 1 2 3 5 8 13 。。。
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
示例1
输入
4

返回值
3
*/

@Test
public void myTest(){
	System.out.println(Fibonacci(6));
}
		public int Fibonacci1(int n) {
			if (n==0){
				return 0;
			}
			if (n<2){
				return 1;
			}
			int[] dp = new int[n];
			dp[0]=1;
			dp[1]=1;
			for (int i = 2; i < n; i++) {
				dp[i]=dp[i-1]+dp[i-2];
			}
			return dp[n-1];
		}
		//优化
	public int Fibonacci(int n) {
		if (n==0){
			return 0;
		}
		if (n<2){
			return 1;
		}
//		int[] dp = new int[n];
//		dp[0]=1;
//		dp[1]=1;
		int dp0=1;
		int dp1=1;
		int dpn=dp0+dp1;
		for (int i = 2; i < n; i++) {
			dpn=(dp0+dp1)%1000000008;
			dp0=dp1;
			dp1=dpn;
		}
		return dpn;
	}

}
