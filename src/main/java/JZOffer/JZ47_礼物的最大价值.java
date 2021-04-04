package JZOffer;

import org.junit.Test;

import java.util.Arrays;

public class JZ47_礼物的最大价值 {
	/*在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
	你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
	给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
输入:
[
 [1,3,1],
 [1,5,1],
 [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
*/
	//标签是动态规划，如果没看到的话我第一想法是贪心。
	//公式： dp[m][n] = max(dp[m-1][n],dp[m][n-1])
	//徒手完成最优解！！
	//使用循环变量减少空间复杂度。同时先完成第一行第一列的冗余判断，增加效率
//	class Solution {
	@Test
	public void myTest(){
		int[][] ints = {
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
		System.out.println(maxValue(ints));
	}
	
		public int maxValue(int[][] grid) {
			int[][] dp = new int[grid.length][grid[0].length];

			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[0].length; j++) {
					if (i==0&&j==0){
						dp[i][j]= grid[i][j];
					}else if (i==0){
						dp[i][j]= dp[i][j-1]+grid[i][j];
					}else if (j==0){
						dp[i][j]= dp[i-1][j]+grid[i][j];
//					}else if (i==dp.length){
//						dp[i][j]= dp[i][j-1]+grid[i][j];
//					}else if (j==dp[0].length-1){
//						dp[i][j]= dp[i-1][j]+grid[i][j];
					}else {
						dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
					}
				}
			}
			return dp[grid.length-1][grid[0].length-1];
		}

	class Solution {
		public int maxValue(int[][] grid) {
			int m = grid.length, n = grid[0].length;
			for(int j = 1; j < n; j++) // 初始化第一行
				grid[0][j] += grid[0][j - 1];
			for(int i = 1; i < m; i++) // 初始化第一列
				grid[i][0] += grid[i - 1][0];
			for(int i = 1; i < m; i++)
				for(int j = 1; j < n; j++)
					grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
			return grid[m - 1][n - 1];
		}
	}

	//如果对空间要求不高，可以使用多加一行一列来使得代码更加简易；我最开始就是想这样实现的，但是不熟练
	public int maxValue2(int[][] grid) {
		int row = grid.length;
		int column = grid[0].length;
		//dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
		int[][] dp = new int[row + 1][column + 1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
			}
		}
		return dp[row][column];
	}

//	}
}
