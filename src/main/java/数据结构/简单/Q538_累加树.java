package 数据结构.简单;

public class Q538_累加树 {
     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/*
* 题目的关键在于如何从最右边开始遍历
* 说到底就是从右到左的中序遍历
* */

//回溯
    class Solution {
         int sum=0;
        public TreeNode convertBST(TreeNode root) {
            if (root==null) return null;

            convertBST(root.right);
            sum+=root.val;
            root.val = sum;
            convertBST(root.left);

            return root;
        }
    }


}
