package 数据结构.中等;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Q145_后序遍历 {
    /*给定一个二叉树，返回它的 后序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [3,2,1]
    * */
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//迭代
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            ArrayList<Integer> res = new ArrayList<>();
            TreeNode pre=null;
            while (!q.isEmpty() || root!=null){
                while (root!=null){
                    q.offer(root);
                    root=root.left;
                }
                root = q.removeLast();
                if (root.right==null || root.right==pre){
                    res.add(root.val);
                    pre=root;
                    root=null;
                }else {
                    q.offer(root);
                    root=root.right;
                }
            }
            return res;
        }

}






  //递归
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            postOrder(root,res);
            return res;
        }

        public void postOrder (TreeNode root,List<Integer> res){
            if ( root==null) return;
            postOrder(root.left,res);
            postOrder(root.right,res);
            res.add(root.val);
        }
    }
}























