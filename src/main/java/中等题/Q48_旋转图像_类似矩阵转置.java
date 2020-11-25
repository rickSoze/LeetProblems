package 中等题;

import org.junit.Test;

public class Q48_旋转图像_类似矩阵转置 {
    /*给定一个 n × n 的二维矩阵表示一个图像。图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
    * */




    //先转置，再镜像对称


    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int temp=0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            for (int j = 0; j < n/2; j++) {
                for (int i = 0; i < n; i++) {
                    temp = matrix[i][j];
                    matrix[i][j]=matrix[i][n-j-1];
                    matrix[i][n-j-1] = temp;
                }
            }

            return;
        }
    }
}