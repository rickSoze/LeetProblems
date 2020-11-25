package 数据结构.简单;

public class Q100_相同的树 {
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

    class Solution {
        boolean flag = true;
        public boolean isSameTree(TreeNode p, TreeNode q) {
            traverseTree(p,q);
            return flag;
        }

        public void traverseTree(TreeNode p, TreeNode q){
            if (p==null&&q!=null) {
                flag = false;
                return;
            }
            if (p!=null&&q==null) {
                flag = false;
                return;
            }
            if(p==null && q==null ) return;
            if (p.val!=q.val) flag=false;
            traverseTree(p.left,q.left);
            traverseTree(p.right,q.right);
        }
    }


    class Solution2 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null)
                return true;
            if(p == null || q == null)
                return false;
            if(p.val != q.val)
                return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }







}
