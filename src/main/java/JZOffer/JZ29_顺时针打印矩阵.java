package JZOffer;

import org.junit.Test;

public class JZ29_顺时针打印矩阵 {
	/*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：
输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
*/
	//思路：循环、判断是否越界，移动-》循环
	//这种题应该就这一种思路了，看了一下题解，也是这样做的，代码可以优化一下


//	class Solution {
	@Test
	public void myTest(){
//		int[][] ints = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		for (int i : spiralOrder(ints)) {
			System.out.print(i+" ");
		}
	}
	
		public int[] spiralOrder(int[][] matrix) {
			int left=0,top=0;
			int bottom = matrix.length;
			int right = matrix[0].length;

			int total = (right)*(bottom);
			int[] res = new int[total];
			int cnt=0;
			while (cnt<total){
				//右移
				for (int i = left; i < right; i++) {
					if (cnt==total){
					    break;
					}
					res[cnt++] = matrix[top][i];
				}
				top++;

				//下移
				for (int i = top; i < bottom; i++) {
					if (cnt==total){
						break;
					}
					res[cnt++] = matrix[i][right-1];
				}

				right--;

				//左移
				for (int i = right-1; i >= left ; i--) {
					if (cnt==total){
						break;
					}
					res[cnt++] = matrix[bottom-1][i];
				}
				bottom--;

				//上移
				for (int i = bottom-1; i >= top; i--) {
					if (cnt==total){
						break;
					}
					res[cnt++] = matrix[i][left];
				}
				left++;
			}
			return res;
		}
//	}
class Solution {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0) return new int[0];
		int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
		int[] res = new int[(r + 1) * (b + 1)];
		while(true) {
			for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
			if(++t > b) break;
			for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
			if(l > --r) break;
			for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
			if(t > --b) break;
			for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
			if(++l > r) break;
		}
		return res;
	}
}

}
