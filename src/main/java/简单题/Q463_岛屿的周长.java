package 简单题;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

public class Q463_岛屿的周长 {
    /*
给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，
但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

示例
输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
输出: 16
*/

//    @Test
//    public void test() {
//        int[][] a = {
//                {0, 1, 0, 0},
//                {1, 1, 1, 0},
//                {0, 1, 0, 0},
//                {1, 1, 0, 0}
//        };
//
////        System.out.println(islandPerimeter(a));
//
//        islandPerimeter(a);
//    }


    // 直接遍历数组，只要前面有相邻的方格，就-2
    class Solution3 {
        public int islandPerimeter(int[][] grid) {
            //重点关注前面遍历过得方格，如果之前有相邻方格，就-2;
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int rsp = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        rsp += 4;
                        if (i > 0 && grid[i - 1][j] == 1) {
                            rsp -= 2;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            rsp -= 2;
                        }
                    }
                }
            }
            return rsp;
        }
    }


    //dfs
    class Solution2 {
        public int islandPerimeter(int[][] grid) {
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (grid[r][c] == 1) {
                        // 题目限制只有一个岛屿，计算一个即可
                        return dfs(grid, r, c);
                    }
                }
            }
            return 0;
        }

        int dfs(int[][] grid, int r, int c) {
            if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
                return 1;
            }
            if (grid[r][c] == 0) {
                return 1;
            }
            if (grid[r][c] != 1) {
                return 0;
            }
            grid[r][c] = 2;
            return dfs(grid, r - 1, c)
                    + dfs(grid, r + 1, c)
                    + dfs(grid, r, c - 1)
                    + dfs(grid, r, c + 1);
        }

    }

//直接迭代并判断边数
    class Solution {
         int[] dx = {0, 1, 0, -1};
         int[] dy = {1, 0, -1, 0};

        public int islandPerimeter(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 1) {
                        int cnt = 0;
                        for (int k = 0; k < 4; ++k) {
                            int tx = i + dx[k];
                            int ty = j + dy[k];
                            if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                                cnt += 1;
                            }
                        }
                        ans += cnt;
                    }
                }
            }
            return ans;
        }
    }

}
