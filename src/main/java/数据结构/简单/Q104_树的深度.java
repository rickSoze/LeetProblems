package 数据结构.简单;

public class Q104_树的深度 {





    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    class Solution {
        public int maxDepth(TreeNode root) {
            if (root==null) return 0;

            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);

            int maxh = lh>rh? lh:rh;

            return maxh +1;
        }
    }
}
