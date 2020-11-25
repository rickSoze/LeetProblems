package 数据结构.简单;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q107_二叉树的层次遍历II {
    /*给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：
[
  [15,7],
  [9,20],
  [3]
]
*/


//    @Test
////    public void test(){
////        TreeNode node = new TreeNode(1);
////        node.left = new TreeNode(2);
////        node.right = new TreeNode(3);
////        node.right.left = new TreeNode(4);
////        node.right.right = new TreeNode(5);
////        levelOrderBottom(node) ;
////    }

   class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root==null) return res;
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()){
                ArrayList<Integer> list = new ArrayList<>();
                int size = q.size();
                for (int i = 0; i <size ; i++) {
                    TreeNode p = q.poll();
                    list.add(p.val);
                    if (p.left!=null)
                        q.offer(p.left);
                    if (p.right!=null)
                        q.offer(p.right);
                }
                res.add(0,list);   //这里添加的list应该每次都新建一个，和回溯的list是一样的
                                        //否则每次添加的都是同一个list，之前添加的就会被覆盖了；
            }
            return res;
        }
    }


}
