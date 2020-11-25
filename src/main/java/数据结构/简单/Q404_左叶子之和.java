package 数据结构.简单;

public class Q404_左叶子之和 {
    /*计算给定二叉树的所有左叶子之和。
示例：
    3
   / \
  9  20
    /  \
   15   7
在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
   * */

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    class Solution {
        int sum=0;
        public int sumOfLeftLeaves(TreeNode root) {
            preOrder(root,0);
            return sum;
        }
        public void preOrder(TreeNode root,int tag){
            if (root==null) return;
            if (tag==1&&root.left==null&&root.right==null){
                sum+=root.val;
            }
            preOrder(root.left,1);
            preOrder(root.right,0);
        }
    }
}
