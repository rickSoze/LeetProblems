package 数据结构.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144_二叉树的前序遍历 {
    /*给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
*/

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
    //递归
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if(root==null) return res;
            preOrder(root,res);
            return res;
        }

        public void preOrder(TreeNode node,List<Integer> res){
            if (node==null) return;

            res.add(node.val);
            preOrder(node.left,res);
            preOrder(node.right,res);
            return;
        }
    }


    //迭代
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> q = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();
            if (root==null) return res;

            TreeNode node = root;

            while (!q.isEmpty() || node!=null){
                while (node!=null){
                    q.push(node);
                    res.add(node.val);
                    node = node.left;
                }
                node = q.pop();
                node = node.right;
            }

            return res;
        }
    }

}
