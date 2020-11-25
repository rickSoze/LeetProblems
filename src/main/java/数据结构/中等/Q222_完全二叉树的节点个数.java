package 数据结构.中等;

public class Q222_完全二叉树的节点个数 {
    /* 给出一个完全二叉树，求出该树的节点个数。
说明：

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
示例:
输入:
    1
   / \
  2   3
 / \  /
4  5 6

输出: 6
*/
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 遍历树然后计数，没什么意义。 应该使用完全二叉树的性质解决

    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = countLevel(root.left);
            int right = countLevel(root.right);
            if (left == right) {
                return countNodes(root.right) + (1 << left);
            } else {
                return countNodes(root.left) + (1 << right);
            }
        }

        private int countLevel(TreeNode root) {
            int level = 0;
            while (root != null) {
                level++;
                root = root.left;
            }
            return level;
        }

    }
}























