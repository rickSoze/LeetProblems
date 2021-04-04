package 中等题;

public class Q304_二维区域和检索_矩阵不可变 {
	/*给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，
	右下角为 (row2,col2) 。
上图子矩阵左上角(row1, col1) = (2, 1)，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
示例：

给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
*/

	/*
	*
	* https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/ru-he-qiu-er-wei-de-qian-zhui-he-yi-ji-y-6c21/
	* 讲得很详细。
	* */
	class NumMatrix {
		int[][] m;
		int[][] preSum;
		public NumMatrix(int[][] matrix) {
			m = matrix;
			int x  = matrix.length;
			int y;
			y = x == 0 ? 0 : matrix[0].length;

			preSum = new int[x+1][y+1];
			for (int i = 1; i <= x; i++) {
				for (int j = 1; j <= y; j++) {
					preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + m[i-1][j-1];
				}
			}

		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
		}
	}
}
