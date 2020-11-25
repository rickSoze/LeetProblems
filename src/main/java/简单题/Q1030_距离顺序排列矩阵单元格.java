package 简单题;

import java.util.ArrayList;
import java.util.Comparator;

public class Q1030_距离顺序排列矩阵单元格 {
/*给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。

另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。
（你可以按任何满足此条件的顺序返回答案。）
示例 1：
输入：R = 1, C = 2, r0 = 0, c0 = 0
输出：[[0,0],[0,1]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
示例 2：
输入：R = 2, C = 2, r0 = 0, c0 = 1
输出：[[0,1],[0,0],[1,1],[1,0]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
[[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
*/

    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int[][] res = new int[R*C][2];

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {

                }
            }


            return res;
        }
    }



class Solution2 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        ArrayList<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                list.add(new Integer[]{i,j});

            }
        }
        list.sort(Comparator.comparingInt(i -> Math.abs(i[0] - r0) + Math.abs(i[1] - c0)));
        int k=0;
        for (Integer[] a :list
             ) {
            res[k][0]=a[0];
            res[k][1]=a[1];
            k++;
        }

        return res;
    }
}

}
