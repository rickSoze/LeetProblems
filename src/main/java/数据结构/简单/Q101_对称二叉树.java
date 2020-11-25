package 数据结构.简单;

import java.util.LinkedList;

public class Q101_对称二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //采用队列的方式
    class Solution3 {
        public boolean isSymmetric(TreeNode root) {
            if(root==null || (root.left==null && root.right==null)) {
                return true;
            }
            //用队列保存节点
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            //将根节点的左右孩子放到队列中
            queue.add(root.left);
            queue.add(root.right);
            while(queue.size()>0) {
                //从队列中取出两个节点，再比较这两个节点
                TreeNode left = queue.removeFirst();
                TreeNode right = queue.removeFirst();
                //如果两个节点都为空就继续循环，两者有一个为空就返回false
                if(left==null && right==null) {
                    continue;
                }
                if(left==null || right==null) {
                    return false;
                }
                if(left.val!=right.val) {
                    return false;
                }
                //将左节点的左孩子， 右节点的右孩子放入队列
                queue.add(left.left);
                queue.add(right.right);
                //将左节点的右孩子，右节点的左孩子放入队列
                queue.add(left.right);
                queue.add(right.left);
            }

            return true;
        }
    }

//递归
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root==null||root.left==null&&root.right==null) return true;
            if (root.left==null||root.right==null) return false;
            return judge(root.left,root.right);
        }

        public boolean judge(TreeNode l,TreeNode r){
            if (l == null && r == null) return true;
            if (l == null || r == null) return false;
            return l.val==r.val
                    && judge(l.left,r.right)
                    && judge(l.right,r.left);
        }
    }

    class Solution2w {
        public boolean isSymmetric(TreeNode root) {
            return judge(root,root);
        }

        public boolean judge(TreeNode l,TreeNode r){
            if (l == null && r == null) return true;
            if (l == null || r == null) return false;
            return l.val==r.val
                    && judge(l.left,r.right)
                    && judge(l.right,r.left);
        }
    }




}
