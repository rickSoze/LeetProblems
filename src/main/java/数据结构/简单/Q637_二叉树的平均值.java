package 数据结构.简单;

import java.util.*;

public class Q637_二叉树的平均值 {
    /*
    * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
示例 1：
输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
*/

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //简单的广度优先搜索，注意判断每一层有几个节点即可；
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            ArrayList<Double> list = new ArrayList<>();
            bfs(root,list);
            return list;
        }

        public void bfs(TreeNode root, List<Double> list){
            Queue<TreeNode> stack = new ArrayDeque<>();
            if (root!=null) stack.offer(root);
            while (!stack.isEmpty()){
                double sum =0;
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode p = stack.poll();
                    sum+=p.val;
                    if (p.left!=null)
                    stack.offer(p.left);
                    if (p.right!=null)
                    stack.offer(p.right);
                }
                list.add(sum/size);
            }
        }
    }

}
