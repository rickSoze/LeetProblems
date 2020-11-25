package 数据结构.简单;

public class Q235_二叉树的最近公共祖先 {
//    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val>p.val && root.val<q.val || root.val<p.val && root.val>q.val)
                return root;
            if (root.val==q.val) return q;
            if (root.val==p.val) return p;
            if (root.val>p.val) return lowestCommonAncestor(root.left,p,q);
            else
                return lowestCommonAncestor(root.right,p,q);
        }
    }
}
