package 中等题;

import org.junit.Test;

import javax.swing.text.rtf.RTFEditorKit;

public class Q79_单词搜索 {
    /*
    * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格
* 是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
*/

    class Solution {
        //    @Test
//        public void test(){
//        exist(new char[][]{
//                {'a', 'b', 'c', 'e'},
//                {'s', 'f', 'c', 's'},
//                {'a', 'd', 'e', 'e'}
//        }, "abcc");
//
//    }
        boolean visited[][];

        public boolean exist(char[][] board, String word) {
            if (board.length * board[0].length < word.length()) return false;
            visited = new boolean[board.length][board[0].length];
            char[] tar = word.toCharArray();
            int x = 0, y = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (search(board, tar, i, j, 0)) return true;
                }
            }
            return false;

        }

        public boolean search(char[][] board, char[] tar, int x, int y, int cnt) {
            if (tar.length - 1 == cnt) {
                return tar[cnt] == board[x][y];
            }
            if (board[x][y] == tar[cnt]) {
                visited[x][y] = true;
                if (y < board[0].length - 1 && !visited[x][y + 1])
                    if (search(board, tar, x, y + 1, cnt + 1))
                        return true;  //右
                if (x < board.length - 1 && !visited[x + 1][y])
                    if (search(board, tar, x + 1, y, cnt + 1))
                        return true;     //下
                if (y > 0 && !visited[x][y - 1])
                    if (search(board, tar, x, y - 1, cnt + 1))
                        return true;                  //左
                if (x > 0 && !visited[x - 1][y])
                    if (search(board, tar, x - 1, y, cnt + 1))
                        return true;                  //上
            }
            visited[x][y] = false;
            return false;


        }
    }


    class Solution2 {

        private boolean[][] marked;

        //        x-1,y
        // x,y-1  x,y    x,y+1
        //        x+1,y
        private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        // 盘面上有多少行
        private int m;
        // 盘面上有多少列
        private int n;
        private String word;
        private char[][] board;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0) {
                return false;
            }
            n = board[0].length;
            marked = new boolean[m][n];
            this.word = word;
            this.board = board;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int start) {
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(start);
            }
            if (board[i][j] == word.charAt(start)) {
                marked[i][j] = true;
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (inArea(newX, newY) && !marked[newX][newY]) {
                        if (dfs(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
                marked[i][j] = false;
            }
            return false;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }

//    public static void main(String[] args) {
//
////        char[][] board =
////                {
////                        {'A', 'B', 'C', 'E'},
////                        {'S', 'F', 'C', 'S'},
////                        {'A', 'D', 'E', 'E'}
////                };
////
////        String word = "ABCCED";
//
//
//        char[][] board = {{'a', 'b'}};
//        String word = "ba";
//        Solution2 solution = new Solution2();
//        boolean exist = solution.exist(board, word);
//        System.out.println(exist);
//    }
    }
}
