package 中等题;

import org.junit.Test;

public class Q62_不同路径 {
	/*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？

输入：m = 3, n = 7
输出：28
*/
	//排列组合，这种数据溢出了
	class Solution {
		public int uniquePaths(int m, int n) {
			return (int) (factorial(m + n - 2) / (factorial(m - 1) * factorial(n - 1)));
		}

		public long factorial(int number) {
			if (number <= 1) {
				return 1;
			} else {
				return number * factorial(number - 1);
			}
		}
	}

	//正常的排列组合
	class Solution2 {
		public int uniquePaths(int m, int n) {
			//只跟第几行第几列有关，从m+n-2步中抽出m-1步
			long ans = 1;
			for (int i = 0; i < Math.min(m - 1, n - 1); i++) {
				ans *= m + n - 2 - i;
				ans /= i + 1;
			}
			return (int) ans;
		}
	}

	//动态规划

	class Solution3 {
		public int uniquePaths(int m, int n) {
			int[][] dp = new int[m][n];
			//第一列都是1
			for (int i = 0; i < m; i++) {
				dp[i][0] = 1;
			}
			//第一行都是1
			for (int i = 0; i < n; i++) {
				dp[0][i] = 1;
			}

			//这里是递推公式
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
			return dp[m - 1][n - 1];
		}

	}
}
