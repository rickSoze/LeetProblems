package 数据结构.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q_94二叉树的中序遍历 {


     class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }


     //使用栈 + 迭代实现

    class Solution2 {

        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
            return list;
        }
    }






//最简单的递归遍历；
    class Solution {
         List<Integer> list = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if(root==null) return list;
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
            return list;
        }

        public void inOrder(TreeNode t){
            inOrder(t.left);
            list.add(t.val);
            inOrder(t.right);
            return;
        }
    }
}
