package 数据结构.中等;

public class Q129_求根到叶子节点数字之和 {
    /*给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
例如，从根到叶子节点路径 1->2->3 代表数字 123。
计算从根到叶子节点生成的所有数字之和。
说明: 叶子节点是指没有子节点的节点。

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
    * */
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    class Solution {
        int sum;

        public int sumNumbers(TreeNode root) {
            sum = 0;
            childSum(0, root);
            return sum;
        }
        public  void  childSum(int val, TreeNode root) {
            if(root == null) return;
            int k = (val * 10 + root.val) ;
            if(root.left == null && root.right == null) {
                sum += k;
            }
            childSum(k, root.left);
            childSum(k, root.right);
        }
    }
}
