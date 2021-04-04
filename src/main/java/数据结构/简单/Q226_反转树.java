package 数据结构.简单;

public class Q226_反转树 {



 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root==null) return null;
             TreeNode leftNode = invertTree(root.left);
             TreeNode rightNode = invertTree(root.right);
            root.left = rightNode;
            root.right = leftNode;
            return root;
        }
    }
}
