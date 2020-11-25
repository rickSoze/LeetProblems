package 数据结构.中等;

import java.util.*;

public class Q230_二叉搜索树中第k小的元素 {
    /*给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
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

  //迭代，找到数字直接返回
  class Solution {
      public int kthSmallest(TreeNode root, int k) {
          Stack<TreeNode> stack = new Stack<>();
          while (true){
              while (root!=null){
                  stack.push(root);
                  root =root.left;
              }
              root = stack.pop();
              if (--k==0) return root.val;
              root = root.right;
          }
      }
  }




  //中序遍历树，保存到一个list中，直接输出第k-1个数
  class Solution2{
      public int kthSmallest(TreeNode root, int k) {
          List<Integer> list = inOrder(root, new ArrayList<Integer>());
          return list.get(k-1);
      }

      public List<Integer> inOrder(TreeNode node, List<Integer> list){
          if (node==null) return list;
          inOrder(node.left,list);
          list.add(node.val);
          inOrder(node.right,list);
          return list;
      }
  }




  //我的思路： 先序遍历把元素加入list，然后排序输出；
        // 问题： 没有利用二叉搜索树的性质： 中序遍历输出的就是已经排列好的元素
    class Solution1 {
          List<Integer> list = new ArrayList<>();
        public int kthSmallest(TreeNode root, int k) {
            list.add(Integer.MIN_VALUE);
            preOrder(root);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            return list.get(k-1);
        }

        public void preOrder(TreeNode root){
            if (root==null) return;
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
